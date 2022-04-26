package com.nxh.shop.model;


import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class CategoryDto {
	
	private Long categoryId;
	@NotEmpty(message = "Tên danh mục không được trống")
	@Length(min = 2, message = "Tên danh mục tối thiểu 5 ký tự")
	private String name;
	
	private String description;
	public CategoryDto() {
		super();
	}
	
	public CategoryDto(Long categoryId, String name, String description) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
	}	
	
	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
