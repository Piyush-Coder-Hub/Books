package com.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.dao.BookDao;
import com.rest.pojo.Book;

import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BooksController {

	/*
	 * private final Validator validator;
	 * 
	 * public BooksController(Validator validator) { this.validator = validator; }
	 */

	// @Inject
	private BookDao bookDao;

	public BooksController(BookDao dao) {
		this.bookDao = dao;
	}

	@GET
	@UnitOfWork
	public Response getBooks() {
		return Response.ok(bookDao.findAll()).build();
	}

	@GET
	@Path("/{booId}")
	@UnitOfWork
	public Response findBookById(@PathParam("booId") LongParam bookId) {
		return Response.ok(bookDao.findBookById(bookId.get())).build();
	}
	
	@POST
	@Path("/addBook")
	@UnitOfWork
	public Response addBook(Book book) {
		return Response.ok(bookDao.createBook(book)).build();
	}

	/*
	 * @GET
	 * 
	 * @Path("/{id}") public Response getBookId(@PathParam("id") Integer id) { Book
	 * book = BookDao.getBook(id); if (book != null) return
	 * Response.ok(book).build(); else return
	 * Response.status(Status.NOT_FOUND).build(); }
	 */

	/*
	 * @POST public Response createBook(Employee employee) throws URISyntaxException
	 * { // validation Set<ConstraintViolation<Employee>> violations =
	 * validator.validate(employee); Employee e =
	 * BookDB.getEmployee(employee.getId()); if (violations.size() > 0) {
	 * ArrayList<String> validationMessages = new ArrayList<String>(); for
	 * (ConstraintViolation<Employee> violation : violations) {
	 * validationMessages.add(violation.getPropertyPath().toString() + ": " +
	 * violation.getMessage()); } return
	 * Response.status(Status.BAD_REQUEST).entity(validationMessages).build(); } if
	 * (e != null) { BookDB.updateEmployee(employee.getId(), employee); return
	 * Response.created(new URI("/employees/" + employee.getId())) .build(); } else
	 * return Response.status(Status.NOT_FOUND).build(); }
	 * 
	 * @PUT
	 * 
	 * @Path("/{id}") public Response updateEmployeeById(@PathParam("id") Integer
	 * id, Employee employee) { // validation Set<ConstraintViolation<Employee>>
	 * violations = validator.validate(employee); Employee e =
	 * BookDB.getEmployee(employee.getId()); if (violations.size() > 0) {
	 * ArrayList<String> validationMessages = new ArrayList<String>(); for
	 * (ConstraintViolation<Employee> violation : violations) {
	 * validationMessages.add(violation.getPropertyPath().toString() + ": " +
	 * violation.getMessage()); } return
	 * Response.status(Status.BAD_REQUEST).entity(validationMessages).build(); } if
	 * (e != null) { employee.setId(id); BookDB.updateEmployee(id, employee); return
	 * Response.ok(employee).build(); } else return
	 * Response.status(Status.NOT_FOUND).build(); }
	 * 
	 * @DELETE
	 * 
	 * @Path("/{id}") public Response removeEmployeeById(@PathParam("id") Integer
	 * id) { Employee employee = BookDB.getEmployee(id); if (employee != null) {
	 * BookDB.removeEmployee(id); return Response.ok().build(); } else return
	 * Response.status(Status.NOT_FOUND).build(); }
	 */
}
