package com.rest.configuration;

import com.rest.pojo.Book;

import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;

public class HbnBundle extends HibernateBundle<BookConfiguration> {

	public HbnBundle() {
		super(Book.class);
	}

	@Override
	public PooledDataSourceFactory getDataSourceFactory(BookConfiguration configuration) {
		return configuration.getDataSourceFactory();
	}

}
