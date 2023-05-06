package com.example.beans;

import java.util.List;

import com.example.dao.BookDAO;

public class BookBean {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String description;
	private String category;
	private String price;
	private String qtyAvailable;
	private String cover;

	public List<BookBean> getAllBooks() {
		return BookDAO.getAllBooks();
	}

	public List<BookBean> getSearchResults() {
		return BookDAO.searchBooks(title);
	}

	public List<BookBean> getCatog() {
		return BookDAO.getCat(category);
	}

	public BookBean getBook() {
		return BookDAO.getBook(isbn);
	}

	public BookBean() {

	}

	public BookBean(String isbn, String title, String author, String publisher, String description, String category,
			String price, String cover, String qtyAvailable) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.description = description;
		this.category = category;
		this.price = price;
		this.cover = cover;
		this.qtyAvailable = qtyAvailable;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getQtyAvailable() {
		return qtyAvailable;
	}

	public void setQtyAvailable(String qtyAvailable) {
		this.qtyAvailable = qtyAvailable;
	}
}
