package com.rest.module;

import org.hibernate.SessionFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.ProvisionException;
import com.rest.configuration.HbnBundle;

public class HbnModule extends AbstractModule {

	public final HbnBundle hbnBundle;

	private SessionFactory sessionFactory;

	public HbnModule(HbnBundle hbnBundle) {
		this.hbnBundle = hbnBundle;
	}

	@Override
	protected void configure() {
		// bind(org.hibernate.SessionFactory.class).toInstance(hbnBundle.getSessionFactory());

	}

	@Provides
	SessionFactory providesSessionFactory() {

		if (sessionFactory == null) {
			throw new ProvisionException(
					"The Hibernate session factory has not yet been set. This is likely caused by forgetting to call setSessionFactory during Application.run()");
		}

		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
