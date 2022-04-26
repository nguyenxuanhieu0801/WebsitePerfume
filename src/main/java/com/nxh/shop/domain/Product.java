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
@Table(name = "products")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	@Column(columnDefinition = "nvarchar(100) not null")
	private String name;
	@Column(nullable = false)
	private int quantity;
	@Column(nullable = false)
	private double price;
	@Column(length = 200)
	private String image;
	@Column(columnDefinition = "TEXT not null")
	private String description;
	@Column(nullable = false)
	private double discount;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<OrderDetail> orderDetails;

	public Product() {
		super();
		this.createDate = new Date(System.currentTimeMillis());
	}

	public Product(Long productId, String name, int quantity, double price, String image, String description,
			double discount, Date createDate, Category category, Set<OrderDetail> orderDetails) {
		super();
		this.productId = productId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.image = image;
		this.description = description;
		this.discount = discount;
		this.createDate = new Date(System.currentTimeMillis());
		this.category = category;
		this.orderDetails = orderDetails;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", quantity=" + quantity + ", price=" + price
				+ ", image=" + image + ", description=" + description + ", discount=" + discount + ", createDate="
				+ createDate + ", category=" + category + ", orderDetails=" + orderDetails + "]";
	}

	
}
