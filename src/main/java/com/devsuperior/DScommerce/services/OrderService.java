package com.devsuperior.DScommerce.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.DScommerce.domain.Order;
import com.devsuperior.DScommerce.domain.OrderItem;
import com.devsuperior.DScommerce.domain.OrderStatus;
import com.devsuperior.DScommerce.domain.Product;
import com.devsuperior.DScommerce.domain.User;
import com.devsuperior.DScommerce.dto.OrderDTO;
import com.devsuperior.DScommerce.dto.OrderItemDTO;
import com.devsuperior.DScommerce.repositories.OrderItemRepository;
import com.devsuperior.DScommerce.repositories.OrderRepository;
import com.devsuperior.DScommerce.repositories.ProductRepository;
import com.devsuperior.DScommerce.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private UserService userService;

	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		Order product = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

		OrderDTO dto = new OrderDTO(product);
		return dto;
	}

	 @Transactional
	    public OrderDTO insert(OrderDTO dto) {
	        Order order = new Order();
	        order.setMoment(Instant.now());
	        order.setStatus(OrderStatus.WAITING_PAYMENT);

	        User user = userService.authenticated();
	        order.setClient(user);

	        for(OrderItemDTO itemDto : dto.getItems()){
	            Product product = productRepository.getReferenceById(itemDto.getProductId());
	            OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice());
	            order.getItems().add(item);
	        }
	        repository.save(order);
	        orderItemRepository.saveAll(order.getItems());

	        return new OrderDTO(order);
	    }

}