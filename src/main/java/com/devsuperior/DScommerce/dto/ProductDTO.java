package com.devsuperior.DScommerce.dto;

import org.springframework.beans.BeanUtils;

import com.devsuperior.DScommerce.domain.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {

	private Long id;

	@NotBlank(message = "Campo requirido")
	@Size(min = 3, max = 80, message = "Nome precisa de 3 a 80 caracteres")
	private String name;

	@NotBlank(message = "Campo requirido")
	@Size(min = 10, message = "Descrição precisa ter no minimo 10 caracteres")
	private String description;

	@Positive(message = "O preço deve se posistivo")
	private Double price;

	private String imgUrl;
	

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
