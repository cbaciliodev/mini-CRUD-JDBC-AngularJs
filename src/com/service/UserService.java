package com.service;

import java.util.ArrayList;

import com.bean.User;
import com.dao.UserDao;

public class UserService {
	UserDao ud = new UserDao();

	public int addUser(User user) {
		return ud.addUser(user);
	}

	public int updateUser(int userid, User user) {
		return ud.updateUser(userid, user);
	}

	public ArrayList<User> viewUser(int userId) {
		return ud.viewUser(userId);
	}

	public int deleteUser(int userId) {
		return ud.delete(userId);
	}

}
