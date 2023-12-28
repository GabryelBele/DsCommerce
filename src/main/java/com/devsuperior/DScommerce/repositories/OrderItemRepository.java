package com.devsuperior.DScommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.DScommerce.domain.OrderItem;
import com.devsuperior.DScommerce.domain.OrderItemPK;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
