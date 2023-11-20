package com.devsuperior.DScommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.DScommerce.dto.ProductDTO;
import com.devsuperior.DScommerce.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/{id}")
	public ProductDTO findById(@PathVariable(value = "id") Long id) {
		return productService.findById(id);

	}
}
