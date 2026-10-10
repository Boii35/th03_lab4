package com.example.th03.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.th03.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
