package com.userController;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.google.gson.Gson;
import com.service.UserService;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserService();
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader reader = request.getReader();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONParser parser = new JSONParser();
		JSONObject joUser = null;
		try {
			joUser = (JSONObject) parser.parse(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String source = (String) joUser.get("source");

		Gson gson = new Gson();

		if (source.equals("adduser")) {
			try {

				String name = (String) joUser.get("name");
				long phone = Long.parseLong((String) joUser.get("phone"));
				String address = (String) joUser.get("address");
				String gender = (String) joUser.get("gender");
				String country = (String) joUser.get("country");

				User user = new User(name, phone, address, gender, country);
				int status = service.addUser(user);

				if (status != -1) {
					String json1 = gson.toJson("success," + status);
					response.setContentType("text/plain");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(json1);
				} else {
					String json1 = gson.toJson("failure");

					response.setContentType("text/plain");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(json1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (source.equals("updateuser")) {
			try {
				int userid = Integer.parseInt((String) joUser.get("id"));
				String name = (String) joUser.get("name");
				long phone = Long.parseLong((String) joUser.get("phone"));
				String address = (String) joUser.get("address");
				String gender = (String) joUser.get("gender");
				String country = (String) joUser.get("country");

				User user = new User(name, phone, address, gender, country);
				int status = service.updateUser(userid, user);
				if (status > 0) {
					String json1 = gson.toJson("success");

					response.setContentType("text/plain");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(json1);
				} else {
					String json1 = gson.toJson("failure");

					response.setContentType("text/plain");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(json1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (source.equals("viewuser")) {
			try {
				int userid = Integer.parseInt((String) joUser.get("id"));
				ArrayList<User> users = service.viewUser(userid);
				if (users != null) {
					String json1 = gson.toJson("success,"
							+ users.get(0).getUserName() + ","
							+ users.get(0).getUserContact() + ","
							+ users.get(0).getAddress() + ","
							+ users.get(0).getGender() + ","
							+ users.get(0).getCountry() + ",");
					response.setContentType("text/plain");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(json1);

				} else {
					String json1 = gson.toJson("failure");

					response.setContentType("text/plain");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(json1);
				}
			} catch (Exception e) {
				//e.printStackTrace();
			}
		} else if (source.equals("deleteuser")) {
			try {
				int userid = Integer.parseInt((String) joUser.get("id"));
				int status = service.deleteUser(userid);
				if (status > 0) {
					String json1 = gson.toJson("success");

					response.setContentType("text/plain");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(json1);
				} else {
					String json1 = gson.toJson("failure");

					response.setContentType("text/plain");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(json1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
