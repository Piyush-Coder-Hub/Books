package com.rest.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "author")
@NamedQueries({ @NamedQuery(name = "com.rest.pojo.author.findAll", query = "select e from Author e"),
		@NamedQuery(name = "com.rest.pojo.author.findAuthorById", query = "select e from Author e where e.authorId=:authorId"),
		@NamedQuery(name = "com.rest.pojo.author.findBookByAuthorId", query = "SELECT b " + "FROM Author a, Book b "
				+ "WHERE a.authorId = b.book_auth_id AND a.id = :authorId") })
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_id", nullable = false, columnDefinition = "int default 1")
	private long authorId;
	@Column(name = "author_Name")
	private String authorName;

	public Author() {
	}

	public Author(long id, String name) {
		this.authorId = id;
		this.authorName = name;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
