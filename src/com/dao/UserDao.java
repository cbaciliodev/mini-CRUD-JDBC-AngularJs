package com.dao;

import java.sql.*;
import java.util.ArrayList;

import com.bean.User;
import com.util.DatabaseUtil;

public class UserDao {
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public int addUser(User user) {
		int add = 0;
		try {
			con = DatabaseUtil.getConnection();
			pst = con
					.prepareStatement("insert into user_registration(user_name,user_contact,address,gender,country) values(?,?,?,?,?)");
			pst.setString(1, user.getUserName());
			pst.setLong(2, user.getUserContact());
			pst.setString(3, user.getAddress());
			pst.setString(4, user.getGender());
			pst.setString(5, user.getCountry());
			add = pst.executeUpdate();
			pst = con
					.prepareStatement("select max(user_id) from user_registration");
			int id = Integer.parseInt(pst.executeQuery().getString(1));
			DatabaseUtil.closeStatement(pst);
			DatabaseUtil.closeConnection(con);
			if (add == 1) {
				return id;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public ArrayList<User> viewUser(int userId) {
		ArrayList<User> userlist = new ArrayList<User>();
		User user = new User();
		try {
			con = DatabaseUtil.getConnection();
			pst = con
					.prepareStatement("select * from user_registration where user_id=?");
			pst.setInt(1, userId);
			rs = pst.executeQuery();
			while (rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserContact(rs.getLong(3));
				user.setAddress(rs.getString(4));
				user.setGender(rs.getString(5));
				user.setCountry(rs.getString(6));

				userlist.add(user);
			}
			DatabaseUtil.closeStatement(pst);
			DatabaseUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userlist;
	}

	public int updateUser(int userid, User user) {
		int update = 0;
		try {
			con = DatabaseUtil.getConnection();
			pst = con
					.prepareStatement("update user_registration set user_name=?,user_contact=?,address=?,gender=?,country=? where user_id=?");
			pst.setString(1, user.getUserName());
			pst.setLong(2, user.getUserContact());
			pst.setString(3, user.getAddress());
			pst.setString(4, user.getGender());
			pst.setString(5, user.getCountry());
			pst.setInt(6, userid);
			update = pst.executeUpdate();

			DatabaseUtil.closeStatement(pst);
			DatabaseUtil.closeConnection(con);

			if (update == 1) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(int userId) {
		int delete = 0;
		try {
			con = DatabaseUtil.getConnection();
			pst = con
					.prepareStatement("delete from user_registration where user_id=?");
			pst.setInt(1, userId);
			delete = pst.executeUpdate();
			DatabaseUtil.closeStatement(pst);
			DatabaseUtil.closeConnection(con);
			if (delete == 1) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
