package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbc;

	public Integer addUser(UserBean user) {
		Integer i = 0;

		String qry = "INSERT INTO USERS (FULLNAME, EMAIL, PASSWORD, PROFILE_IMG_PATH) VALUES (?, ?, ?, ?)";
		try {
			i = jdbc.update(qry, user.getFullname(), user.getEmail(), user.getPassword(), user.getProfile_img_path());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public UserBean getUserByEmail(String email) {
		String qry = "SELECT * FROM USERS WHERE EMAIL = ?";
		UserBean dbuser = null;
		try {
			dbuser = jdbc.queryForObject(qry, new BeanPropertyRowMapper<>(UserBean.class), new Object[] { email });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dbuser;
	}

	public Integer updateUserOtp(String email, String otp, String dateTime) {
		String qry = "UPDATE USERS SET OTP = ?, CREATEDAT = ? WHERE EMAIL = ?";
		Integer i = 0;
		try {
			i = jdbc.update(qry, otp, dateTime, email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public Integer updateUserPassword(String email, String password) {
		String qry = "UPDATE USERS SET PASSWORD = ? WHERE EMAIL = ?";
		Integer i = 0;
		try {
			i = jdbc.update(qry, password, email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}
