package com.rest.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "book")
@NamedQueries({ @NamedQuery(name = "com.rest.pojo.book.findAll", query = "select e from Book e"),
		@NamedQuery(name = "com.rest.pojo.book.findBookById", query = "select e from Book e where e.bookId=:bookId") })
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id"  , nullable = false, columnDefinition = "int default 1") 
	@JsonIgnore
	private long bookId;
	@Column(name = "bookName")
	private String bookName;
	@Column(name = "page")
	private int page;

	@ManyToOne
	@JoinColumn(name = "book_auth_id", referencedColumnName = "author_id")
	@JsonIgnore
	private Author book_auth_id;

	public Book() {
	}

	public Book(long id, String name, int page) {
		this.bookId = id;
		this.bookName = name;
		this.page = page;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Author getBook_auth_id() {
		return book_auth_id;
	}

	public void setBook_auth_id(Author book_auth_id) {
		this.book_auth_id = book_auth_id;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", page=" + page + "]";
	}

}
