package com.nagarro.trainingAssignments.Assignment5Boot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "Book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookId")
	private int bookid;
	@Column(name = "bookCode", nullable = false, unique = true)
	private String bookCode;
	@Column(name = "name")
	private String name;
	@Column(name = "author")
	private String author;
	@Column(name = "addedOn")
	private Date addedOn;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String bookCode, String name, String author, Date addedOn) {
		super();
		this.bookCode = bookCode;
		this.name = name;
		this.author = author;
		this.addedOn = addedOn;
	}

	public int getBookId() {
		return bookid;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public void setBookId(int id) {
		this.bookid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	@Override
	public String toString() {
		return "Book [id=" + bookid + ", name=" + name + ", author=" + author + ", addedOn=" + addedOn + "]";
	}

}
