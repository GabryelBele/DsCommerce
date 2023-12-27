package com.devsuperior.DScommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.DScommerce.domain.Order;
import com.devsuperior.DScommerce.dto.OrderDTO;
import com.devsuperior.DScommerce.repositories.OrderRepository;
import com.devsuperior.DScommerce.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order product = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));

        OrderDTO dto = new OrderDTO(product);
        return dto;
    }

}