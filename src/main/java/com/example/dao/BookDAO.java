package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.example.beans.BookBean;

public class BookDAO {

	public static List<BookBean> getAllBooks() {
		Connection con = Database.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from books order by title");
			ResultSet rs = ps.executeQuery();
			ArrayList<BookBean> books = new ArrayList<BookBean>();
			while (rs.next()) {
				byte[] imgData = rs.getBytes("cover");
				String cover = Base64.getEncoder().encodeToString(imgData);
				BookBean book = new BookBean(rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
						rs.getString("publisher"), rs.getString("description"), rs.getString("category"),
						rs.getString("price"), cover, rs.getString("qtyAvailable"));
				books.add(book);
			}
			return books;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static List<BookBean> searchBooks(String title) {
		Connection con = Database.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from books where (upper(title) like '%"
					+ title.toUpperCase() + "%' ) or (upper(author) like '%" + title.toUpperCase() + "%')");
//			ps.setString(1, "%" + title.toUpperCase() + "%");
			ResultSet rs = ps.executeQuery();
			ArrayList<BookBean> books = new ArrayList<BookBean>();
			while (rs.next()) {
				byte[] imgData = rs.getBytes("cover");
				String cover = Base64.getEncoder().encodeToString(imgData);
				BookBean book = new BookBean(rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
						rs.getString("publisher"), rs.getString("description"), rs.getString("category"),
						rs.getString("price"), cover, rs.getString("qtyAvailable"));
				books.add(book);
			}
			return books;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<BookBean> getCat(String category) {
		Connection con = Database.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from books where upper(category)=?");
			ps.setString(1, category.toUpperCase());
			ResultSet rs = ps.executeQuery();
			ArrayList<BookBean> books = new ArrayList<BookBean>();
			while (rs.next()) {
				byte[] imgData = rs.getBytes("cover");
				String cover = Base64.getEncoder().encodeToString(imgData);
				BookBean book = new BookBean(rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
						rs.getString("publisher"), rs.getString("description"), rs.getString("category"),
						rs.getString("price"), cover, rs.getString("qtyAvailable"));
				books.add(book);
			}
			return books;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static BookBean getBook(String isbn) {
		Connection con = Database.getConnection();
		BookBean book = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from books where isbn = ?");
			ps.setString(1, isbn);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				byte[] imgData = rs.getBytes("cover");
				String cover = Base64.getEncoder().encodeToString(imgData);
				book = new BookBean(rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
						rs.getString("publisher"), rs.getString("description"), rs.getString("category"),
						rs.getString("price"), cover, rs.getString("qtyAvailable"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

}
