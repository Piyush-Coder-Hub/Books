package com.rest.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.rest.pojo.Author;

import io.dropwizard.hibernate.AbstractDAO;

public class AuthorDao extends AbstractDAO<Author> {

	public AuthorDao(SessionFactory sessionFactory) {
		super(sessionFactory);

	}

	public List<Author> findAll() {
		return list(namedQuery("com.rest.pojo.author.findAll"));
	}

	public long create(Author author) {
		return persist(author).getAuthorId();
	}

	/*
	 * public List<Author> findAuthorById(long authorId) { return
	 * list(namedQuery("com.rest.pojo.author.findAuthorById").setParameter(
	 * "authorId", authorId)); }
	 */

	public List<Author> findBookByAuthorId(long authorId) {
		return list(namedQuery("com.rest.pojo.author.findBookByAuthorId").setParameter("authorId", authorId));
	}

}
