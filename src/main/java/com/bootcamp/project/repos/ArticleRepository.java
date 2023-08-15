package com.bootcamp.project.repos;

import com.bootcamp.project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Product, Long> {
}
