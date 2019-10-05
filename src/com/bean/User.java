package com.bean;

public class User {
	private int userId;
	private String userName;
	private long userContact;
	private String address;
	private String gender;
	private String country;

	public User(String userName, long userContact, String address,
			String gender, String country) {
		super();

		this.userName = userName;
		this.userContact = userContact;
		this.address = address;
		this.gender = gender;
		this.country = country;
	}

	public User() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getUserContact() {
		return userContact;
	}

	public void setUserContact(long userContact) {
		this.userContact = userContact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userContact=" + userContact + ", address=" + address
				+ ", gender=" + gender + ", country=" + country + "]";
	}

}
