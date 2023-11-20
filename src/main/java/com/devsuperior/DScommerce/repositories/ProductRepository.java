package com.devsuperior.DScommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.DScommerce.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
