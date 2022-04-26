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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "orders")
public class Order implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	@Column(nullable = false)
	private double amount;
	@Column(nullable = false)
	private short status;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<OrderDetail> orderDetails;

	public Order() {
		super();
	}

	public Order(Long orderId, Date orderDate, double amount, short status, User user,
			Set<OrderDetail> orderDetails) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.amount = amount;
		this.status = status;
		this.user = user;
		this.orderDetails = orderDetails;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short i) {
		this.status = i;
	}	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", amount=" + amount + ", status=" + status
				+ ", user=" + user + ", orderDetails=" + orderDetails + "]";
	}
	
	
}
