package beans;

import DAO.CartDAO;
import java.util.List;

public class CartBean {
	private String isbn, title, cover;
	int quantity;
	float price;

	public CartBean() {

	}

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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public void addQuantity(int quantity) {
		this.quantity += quantity;
	}
}
