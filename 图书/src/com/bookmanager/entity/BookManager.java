package com.bookmanager.entity;

import java.sql.Timestamp;

public class BookManager {
	private int bookId;
	private String bookName;
	private String bookWriter;
	private int bookStatus;
	private Timestamp bookTime;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookWriter() {
		return bookWriter;
	}
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}
	public int getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(int bookStatus) {
		this.bookStatus = bookStatus;
	}
	public Timestamp getBookTime() {
		return bookTime;
	}
	public void setBookTime(Timestamp bookTime) {
		this.bookTime = bookTime;
	}
	public BookManager(int bookId, String bookName, String bookWriter, int bookStatus, Timestamp bookTime) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookWriter = bookWriter;
		this.bookStatus = bookStatus;
		this.bookTime = bookTime;
	}
	public BookManager() {
		super();
	}
	public BookManager(String bookName, String bookWriter) {
		super();
		this.bookName = bookName;
		this.bookWriter = bookWriter;
	}
	public BookManager(int bookId) {
		super();
		this.bookId = bookId;
	}
	
	
}
