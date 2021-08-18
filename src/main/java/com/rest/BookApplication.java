package com.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rest.configuration.BookConfiguration;
import com.rest.controller.AuthorController;
import com.rest.controller.BooksController;
import com.rest.dao.AuthorDao;
import com.rest.dao.BookDao;
import com.rest.pojo.Author;
import com.rest.pojo.Book;

import io.dropwizard.Application;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class BookApplication extends Application<BookConfiguration> {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookApplication.class);

	public static void main(String[] args) throws Exception {
		new BookApplication().run("server", "configuration.yml");
	}

	/*
	 * private HibernateBundle<BookConfiguration> hibernate = new
	 * HibernateBundle<BookConfiguration>(Book.class) {
	 * 
	 * @Override public DataSourceFactory getDataSourceFactory(BookConfiguration
	 * configuration) { return configuration.getDataSourceFactory(); }
	 * 
	 * };
	 */

	/* ImmutableList<Class<?>> classes = new ImmutableList<Class<?>>(); */

	private HibernateBundle<BookConfiguration> hibernate = new HibernateBundle<BookConfiguration>(Book.class,
			Author.class) {

		@Override
		public PooledDataSourceFactory getDataSourceFactory(BookConfiguration configuration) {
			return configuration.getDataSourceFactory();
		}
	};

	@Override
	public void run(BookConfiguration c, Environment e) throws Exception {
		LOGGER.info("Registering REST resources");
		System.out.println("Value from dev.yml is " + c.getDataSourceFactory().getUser());
		/*
		 * final HbnBundle hbnBundle = new HbnBundle(); final HbnModule myModule = new
		 * HbnModule(hbnBundle);
		 * myModule.setSessionFactory(hbnBundle.getSessionFactory());
		 */
		BookDao bookDao = new BookDao(hibernate.getSessionFactory());
		AuthorDao authorDao = new AuthorDao(hibernate.getSessionFactory());
		final BooksController bc = new BooksController(bookDao);
		final AuthorController ac = new AuthorController(authorDao);
		e.jersey().register(bc);
		e.jersey().register(ac);
	}

	@Override
	public void initialize(Bootstrap<BookConfiguration> b) {
		// final HbnBundle hbnBundle = new HbnBundle();
		// b.addBundle(hbnBundle);\
		b.addBundle(hibernate);
		b.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
		// b.addBundle(GuiceBundle.<BookConfiguration>newBuilder().enableAutoConfig(getClass().getPackage().getName()).addModule(new
		// HbnModule(hbnBundle)).setConfigClass(BookConfiguration.class).build());
	}
}
