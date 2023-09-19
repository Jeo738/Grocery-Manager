package com.jeffserson.grocery.manager.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeffserson.grocery.manager.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
