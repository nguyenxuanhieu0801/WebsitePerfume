package com.nxh.shop.domain;

public class CartItem {
	private long productId;
	private String name;
	private int quantity;
	private double price;
	private String image;

	public CartItem() {
		super();
	}

	public CartItem(long productId, String name, int quantity, double price, String image) {
		super();
		this.productId = productId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.image = image;

	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "CartItem [productId=" + productId + ", name=" + name + ", quantity=" + quantity + ", price=" + price
				+ "]";
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
