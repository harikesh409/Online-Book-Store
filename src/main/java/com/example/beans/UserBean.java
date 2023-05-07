package com.example.beans;

import com.example.dao.UserDAO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBean {
    private String email;
	private String password;
	private String name;
	private String address;
	private String city;
	private String country;
	private String gender;
	private String newPassword;
	private String date;

    public boolean login() {
        return UserDAO.login(email, password);
    }

    public boolean register() {
        return UserDAO.register(email, password, name, date, address, city, country, gender);
    }

    public boolean changePassword() {
        return UserDAO.changePassword(email, password, newPassword);
    }
}
