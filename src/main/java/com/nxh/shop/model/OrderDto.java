package com.nxh.shop.model;

import java.util.Date;

public class OrderDto {
	private Long orderId;
	private Date orderDate;
	private double amount;
	private short status;
	private Long userId;

	public OrderDto() {
		super();
	}

	public OrderDto(Long orderId, Date orderDate, double amount, short status, Long userId) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.amount = amount;
		this.status = status;
		this.userId = userId;
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

	public void setStatus(short status) {
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "OrderDto [orderId=" + orderId + ", orderDate=" + orderDate + ", amount=" + amount + ", status=" + status
				+ ", userId=" + userId + "]";
	}
	
	

}
