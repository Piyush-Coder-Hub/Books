package com.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.rest.dao.AuthorDao;
import com.rest.pojo.Author;
import com.rest.pojo.Book;

import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

@Path("/author")
@Produces(MediaType.APPLICATION_JSON)
public class AuthorController {

	private AuthorDao authorDao;

	public AuthorController(AuthorDao dao) {
		this.authorDao = dao;
	}

	@GET
	@UnitOfWork
	public Response getAuthors() {
		return Response.ok(authorDao.findAll()).build();
	}

	@GET
	@Path("/{authorId}")
	@UnitOfWork
	public Response findAuthorById(@PathParam("authorId") LongParam authorId) {
		return Response.ok(authorDao.findBookByAuthorId(authorId.get())).build();
	}

	@POST
	@Path("/addAuthor")
	@UnitOfWork
	public Response addAuthor(Author author) {
		return Response.ok(authorDao.create(author)).build();
	}
	
}
