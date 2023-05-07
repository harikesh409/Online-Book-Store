package com.example.beans;

import java.util.List;

import com.example.dao.BookDAO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BookBean {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String description;
	private String category;
	private float price;
	private int qtyAvailable;
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


	public BookBean(String isbn, String title, String author, String publisher, String description, String category,
			float price, String cover, int qtyAvailable) {
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
}
