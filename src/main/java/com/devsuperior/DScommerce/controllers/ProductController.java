package com.devsuperior.DScommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping
	public Page<ProductDTO> findAll(Pageable pageable) {
		return productService.findAll(pageable);
	}
	
	@PostMapping
	public ProductDTO insert(@RequestBody ProductDTO dto) {
		return productService.insert(dto);

	}
}
