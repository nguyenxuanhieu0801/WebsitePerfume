package com.nxh.shop.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

public class ProductDto {
	private Long productId;
	@NotEmpty(message = "Tên sản phẩm không được trống")
	@Length(min = 5, message = "Tên sản phẩm tối thiểu 5 ký tự")
	private	String name;
	@NotNull(message = "Số lượng sản phẩm không được trống")
	@Min(value = 1, message = "Giá sản phẩm phải lớn hơn không")
	private int quantity;
	@NotNull(message = "Giá sản phẩm không được trống")
	@Min(value = 1, message = "Giá sản phẩm phải lớn hơn không")
	private double price;
	private String image;
	@NotNull(message = "Hình ảnh không được trống")
	private MultipartFile imageFile;
	@NotEmpty(message = "Mô tả không được trống")
	@Length(min = 5, message = "Mô tả tối thiểu 5 ký tự")
	private String description;
	private double discount;
	private Date createDate;	
	private Long categoryId;
	
	public ProductDto() {
		super();
	}	

	public ProductDto(Long productId, String name, int quantity, double price, String image, MultipartFile imageFile,
			String description, double discount, Date createDate,Long categoryId) {
		super();
		this.productId = productId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.image = image;
		this.imageFile = imageFile;
		this.description = description;
		this.discount = discount;
		this.createDate = createDate;
		this.categoryId = categoryId;
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
	
	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
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
	
	public Long getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	
	
}
