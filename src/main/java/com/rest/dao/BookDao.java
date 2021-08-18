package com.rest.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.rest.pojo.Book;

import io.dropwizard.hibernate.AbstractDAO;

public class BookDao extends AbstractDAO<Book> {
	/*
	 * public static HashMap<Integer, Book> books = new HashMap<>(); static {
	 * books.put(1, new Book(1, "aks", 78)); books.put(2, new Book(2, "bbc", 99));
	 * books.put(3, new Book(3, "Melcum", 88)); }
	 */

	/*
	 * @Inject public BookDao(SessionFactory sessionFactory) {
	 * super(sessionFactory); }
	 */

	public BookDao(SessionFactory sessionFactory) {
		super(sessionFactory);

	}

	public List<Book> findAll() {
		return list(namedQuery("com.rest.pojo.book.findAll"));
	}

	public List<Book> findBookById(long bookId) {
		return list(namedQuery("com.rest.pojo.book.findBookById").setParameter("bookId", bookId));
	}

	public long createBook(Book book) {
			return persist(book).getBookId();
	}

	/*
	 * public static List<Book> getBooks() { return new
	 * ArrayList<Book>(books.values()); }
	 * 
	 * public static Book getBook(Integer id) { return books.get(id); }
	 * 
	 * public static void updateEmployee(Integer id, Book Book) { books.put(id,
	 * Book); }
	 * 
	 * public static void removeEmployee(Integer id) { books.remove(id); }
	 */
}
