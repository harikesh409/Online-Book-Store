package com.example.dao;

import com.example.beans.UserBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public static boolean login(String email, String password) {
        Connection con = Database.getConnection();
        ResultSet rs = null;
        boolean found = false;
        try (PreparedStatement ps = con.prepareStatement("select * from users where email = ? and password = ?")) {
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next())
                found = true;
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            found = false;
        }
        return found;
    }

    public static boolean register(String email, String password, String name, String date, String address, String city,
                                   String country, String gender) {
        Connection con = Database.getConnection();
        boolean isRegistered = false;
        try (PreparedStatement ps = con.prepareStatement(
                "insert into users(email,password,dob,name,address,city,country,gender) values(?,?,?,?,?,?,?,?)")) {
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, date);
            ps.setString(4, name);
            ps.setString(5, address);
            ps.setString(6, city);
            ps.setString(7, country);
            ps.setString(8, gender);
            if (ps.executeUpdate() == 1)
                isRegistered = true;
        } catch (SQLException e) {
            e.printStackTrace();
            isRegistered = false;
        }
        return isRegistered;
    }

    public static boolean changePassword(String email, String oldPassword, String newPassword) {

        Connection con = Database.getConnection();
        PreparedStatement ps = null;
        boolean isChanged = false;
        try {
            ps = con.prepareStatement("update users set password = ? where email = ? and password = ?");
            ps.setString(1, newPassword);
            ps.setString(2, email);
            ps.setString(3, oldPassword);
            if (ps.executeUpdate() == 1)
                isChanged = true;
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            isChanged = false;
        }
        return isChanged;
    }

    public static UserBean getUser(String email) {
        Connection con = Database.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserBean user = null;
        try {
            ps = con.prepareStatement("select * from users where email=?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new UserBean();
                user.setName(rs.getString("name"));
                user.setDate(rs.getString("date"));
                user.setAddress(rs.getString("address"));
                user.setCity(rs.getString("city"));
                user.setCountry(rs.getString("country"));
                user.setGender(rs.getString("gender"));
                ps.close();
                rs.close();
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return user;
    }
}
