package com.nxh.shop.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(columnDefinition = "nvarchar(50) not null")
	private String name;
	@Column(columnDefinition = "nvarchar(100) not null")
	private String email;
	@Column(columnDefinition = "varchar(100) not null")
	private String password;
	
	private boolean sex;
	
	private int role;
	@Column(length = 20)
	private String phone;
	@Column(columnDefinition = "nvarchar(100)")
	private String address;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Order> orders;

	public User() {
		super();
		this.createDate = new Date(System.currentTimeMillis());
	}

	public User(Long userId, String name, String email, String password, String phone, String address,boolean sex,int role,
			Date create_at, Set<Order> orders) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.sex = sex;
		this.role = role;
		this.address = address;
		this.createDate = new Date(System.currentTimeMillis());
		this.orders = orders;
	}

	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Set<Order> getOrders() {
		return orders;
	}	

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phone=" + phone + ", address=" + address + ", create_at=" + createDate + "]";
	}
	
	
	
}
