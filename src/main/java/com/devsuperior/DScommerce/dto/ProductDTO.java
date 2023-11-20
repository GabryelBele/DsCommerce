package com.devsuperior.DScommerce.dto;

import org.springframework.beans.BeanUtils;

import com.devsuperior.DScommerce.domain.Product;

public class ProductDTO {

	private Long id;

	private String name;

	private String description;

	private Double price;

	private String imgUrl;
	
	

	public ProductDTO() {
	}



	public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
	public ProductDTO(Product entity) {
		BeanUtils.copyProperties(entity, this);
	}



	public void setId(Long id) {
		this.id = id;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}



	public Long getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public String getDescription() {
		return description;
	}



	public Double getPrice() {
		return price;
	}



	public String getImgUrl() {
		return imgUrl;
	}
	
	
	
	
}
