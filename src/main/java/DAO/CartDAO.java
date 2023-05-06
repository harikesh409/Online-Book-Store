package DAO;

import beans.CartBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import DAO.Database;

public class CartDAO {

	static ArrayList<CartBean> cart = new ArrayList<CartBean>();

	public static CartBean find(String isbn) {
		Iterator<CartBean> itr = cart.iterator();
		CartBean book;
		while (itr.hasNext()) {
			book = (CartBean) itr.next();
			if (book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		return null;
	}

	public static void addToCart(String isbn, int qtny) {
		CartBean book = find(isbn);
		if (book == null) {
			Connection con = Database.getConnection();
			try {
				PreparedStatement ps = con.prepareStatement("select * from books where isbn = ?");
				ps.setString(1, isbn);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					byte[] imgData = rs.getBytes("cover");
					String cover = Base64.getEncoder().encodeToString(imgData);
					book = new CartBean(rs.getString("isbn"), rs.getString("title"), rs.getFloat("price"),
							rs.getInt("qtyAvailable"), cover);
					cart.add(book);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			book.addQuantity(qtny);
		}
	}

	public static List<CartBean> getCart() {
		return cart;
	}

	public static void removeItem(String isbn) {
		CartBean book = find(isbn);
		if(book!=null)
			cart.remove(book);
	}
}
