package com.bootcamp.project.service;

import com.bootcamp.project.model.Product;
import com.bootcamp.project.repos.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product newProduct(Product product){
        return productRepository.save(product);
    }
}
