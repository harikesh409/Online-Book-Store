package com.example.servlets;

import com.example.dao.Database;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/AddBook")
@MultipartConfig
public class AddBook extends HttpServlet {
    private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String msg = null;
		try(Connection con = Database.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into books(ISBN,title,author,publisher,description,category,price,cover,qtyAvailable) values(?,?,?,?,?,?,?,?,?)")) {
            InputStream ip = null;
            String isbnStr = request.getParameter("isbn");
            int isbn = Integer.parseInt(isbnStr);
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String publisher = request.getParameter("publisher");
            String category = request.getParameter("category");
            float price = Float.parseFloat(request.getParameter("price"));
            String description = request.getParameter("description");
            int inStock = Integer.parseInt(request.getParameter("inStock"));
            Part filePart = request.getPart("cover");
            if (filePart != null)
                ip = filePart.getInputStream();
            ps.setInt(1, isbn);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setString(4, publisher);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setFloat(7, price);
            ps.setBlob(8, ip);
            ps.setInt(9, inStock);
            if (ps.executeUpdate() == 1)
                msg = "<span class='text-success'>Book added successfully<span>";
        } catch (Exception e) {
            msg = "<span class='text-danger'>Error: " + e.getMessage() + "</span>";
            e.printStackTrace();
        }
        request.setAttribute("msg", msg);
        getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);

    }

}
