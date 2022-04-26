package com.nxh.shop.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderDetails")
public class OrderDetail implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderDetailId;
	@Column(nullable = false)
	private int quantity;
	@Column(nullable = false)
	private double price;		
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;
	
	public OrderDetail() {
		super();
	}
	
	public OrderDetail(Long orderDetailId, int quantity, double price, Product product, Order order) {
		super();
		this.orderDetailId = orderDetailId;
		this.quantity = quantity;
		this.price = price;
		this.product = product;
		this.order = order;
	}

	public Long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
