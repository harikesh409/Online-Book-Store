package com.example.dao;

import com.example.beans.UserBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDAO {

    public static boolean login(String email, String password) {
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from users where email = ? and password = ?")) {
            ps.setString(1, email);
            ps.setString(2, password);
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next())
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean register(String email, String password, String name, String date, String address, String city,
                                   String country, String gender) {
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement(
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
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean changePassword(String email, String oldPassword, String newPassword) {
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement("update users set password = ? where email = ? and password = ?")) {
            ps.setString(1, newPassword);
            ps.setString(2, email);
            ps.setString(3, oldPassword);
            if (ps.executeUpdate() == 1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static UserBean getUser(String email) {
        UserBean user = null;
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from users where email=?")) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new UserBean();
                    user.setName(rs.getString("name"));
                    user.setDate(rs.getString("date"));
                    user.setAddress(rs.getString("address"));
                    user.setCity(rs.getString("city"));
                    user.setCountry(rs.getString("country"));
                    user.setGender(rs.getString("gender"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
