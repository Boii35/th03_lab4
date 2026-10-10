package com.example.th03.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.th03.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
