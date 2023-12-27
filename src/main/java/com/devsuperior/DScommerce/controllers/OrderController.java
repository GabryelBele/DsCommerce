package com.devsuperior.DScommerce.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.DScommerce.dto.OrderDTO;
import com.devsuperior.DScommerce.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<OrderDTO> findById(@PathVariable(value = "id") Long id) {
		OrderDTO dto = orderService.findById(id);
		return ResponseEntity.ok(dto);
	}

}
