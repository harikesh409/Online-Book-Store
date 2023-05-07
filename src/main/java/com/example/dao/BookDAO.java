package com.example.dao;

import com.example.beans.BookBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookDAO {

    public static List<BookBean> getAllBooks() {
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM books ORDER BY title");
             ResultSet rs = ps.executeQuery()) {
            ArrayList<BookBean> books = new ArrayList<>();
            while (rs.next()) {
                byte[] imgData = rs.getBytes("cover");
                String cover = Base64.getEncoder().encodeToString(imgData);
                BookBean book = new BookBean(rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
                        rs.getString("publisher"), rs.getString("description"), rs.getString("category"),
                        rs.getFloat("price"), cover, rs.getInt("qtyAvailable"));
                books.add(book);
            }
            return books;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static List<BookBean> searchBooks(String title) {
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM books WHERE (UPPER(title) LIKE ?) OR (UPPER(author) LIKE ?)")) {
            ps.setString(1, "%" + title.toUpperCase() + "%");
            ps.setString(2, "%" + title.toUpperCase() + "%");
            try (ResultSet rs = ps.executeQuery()) {
                ArrayList<BookBean> books = new ArrayList<>();
                while (rs.next()) {
                    byte[] imgData = rs.getBytes("cover");
                    String cover = Base64.getEncoder().encodeToString(imgData);
                    BookBean book = new BookBean(rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
                            rs.getString("publisher"), rs.getString("description"), rs.getString("category"),
                            rs.getFloat("price"), cover, rs.getInt("qtyAvailable"));
                    books.add(book);
                }
                return books;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<BookBean> getCat(String category) {

        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from books where upper(category)=?")) {
            ps.setString(1, category.toUpperCase());
            try(ResultSet rs = ps.executeQuery()) {
                ArrayList<BookBean> books = new ArrayList<>();
                while (rs.next()) {
                    byte[] imgData = rs.getBytes("cover");
                    String cover = Base64.getEncoder().encodeToString(imgData);
                    BookBean book = new BookBean(rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
                            rs.getString("publisher"), rs.getString("description"), rs.getString("category"),
                            rs.getFloat("price"), cover, rs.getInt("qtyAvailable"));
                    books.add(book);
                }
                return books;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BookBean getBook(String isbn) {
        BookBean book = null;
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from books where isbn = ?")) {
            ps.setString(1, isbn);
            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    byte[] imgData = rs.getBytes("cover");
                    String cover = Base64.getEncoder().encodeToString(imgData);
                    book = new BookBean(rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
                            rs.getString("publisher"), rs.getString("description"), rs.getString("category"),
                            rs.getFloat("price"), cover, rs.getInt("qtyAvailable"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

}