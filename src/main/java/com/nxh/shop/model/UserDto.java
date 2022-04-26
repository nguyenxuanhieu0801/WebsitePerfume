package com.nxh.shop.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class UserDto {	
	@NotEmpty(message = "Họ và tên không được trống")
	@Length(min = 5, message = "Họ và tên tối thiểu 5 ký tự")
	
	private String name;
	@Length(min = 5, message = "Email tối thiểu 5 ký tự")
	@NotEmpty(message = "Email không được trống")
	@Email(message = "Email không hợp lệ")
	private String email;
	@NotEmpty(message = "Password không được trống")
	@Length(min = 6, message = "Password tối thiểu 6 ký tự")
	private String password;
	private String password2;
	@NotEmpty(message = "Số điện thoại không được trống")
	@Length(min = 10, message = "Số điện thoai tối thiểu 10 ký tự")
	private String phone;
	@NotEmpty(message = "Địa chỉ không được trống")
	private String address;
	private int role;	
	private boolean sex;

	public UserDto() {
		super();
	}

	public UserDto(String name, String email, String password, String password2, String phone, String address, boolean sex) {
		super();
		this.sex = sex;
		this.name = name;
		this.email = email;
		this.password = password;
		this.password2 = password2;
		this.phone = phone;
		this.address = address;
		this.role = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String username) {
		this.email = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "UserDto [name=" + name + ", email=" + email + ", password=" + password + ", password2=" + password2
				+ "]";
	}

}
