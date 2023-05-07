package com.example.beans;

import com.example.dao.CartDAO;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CartBean {
	private String isbn;
	private String title;
	private String cover;
	int quantity;
	float price;

	public CartBean(String isbn, String title, float price, int quantity, String cover) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.cover = cover;
	}

	public void addToCart() {
		CartDAO.addToCart(isbn, quantity);
//		System.out.println(CartDAO.getCart());
	}

	public List<CartBean> getCartItems() {
//		System.out.println(CartDAO.getCart());
		return CartDAO.getCart();
	}
	
	public void removeItem(String isbn) {
		CartDAO.removeItem(isbn);
	}

	public void addQuantity(int quantity) {
		this.quantity += quantity;
	}
}
