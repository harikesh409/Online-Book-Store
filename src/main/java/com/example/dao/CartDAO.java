package com.example.dao;

import com.example.beans.BookBean;
import com.example.beans.CartBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CartDAO {

    static ArrayList<CartBean> cart = new ArrayList<>();

    public static CartBean find(String isbn) {
        Iterator<CartBean> itr = cart.iterator();
        CartBean book;
        while (itr.hasNext()) {
            book = itr.next();
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public static void addToCart(String isbn, int qtny) {
        CartBean book = find(isbn);
        if (book == null) {
            BookBean bookBean = BookDAO.getBook(isbn);
            book = new CartBean(bookBean.getIsbn(), bookBean.getTitle(), bookBean.getPrice(),
                    bookBean.getQtyAvailable(), bookBean.getCover());
            cart.add(book);
        } else {
            book.addQuantity(qtny);
        }
    }

    public static List<CartBean> getCart() {
        return cart;
    }

    public static void removeItem(String isbn) {
        CartBean book = find(isbn);
        if (book != null)
            cart.remove(book);
    }
}
