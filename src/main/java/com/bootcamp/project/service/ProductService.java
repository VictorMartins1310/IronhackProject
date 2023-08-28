package com.bootcamp.project.service;

import com.bootcamp.project.model.Product;
import com.bootcamp.project.repos.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    // Repositories
    private final ProductRepository productRepository;

    public Product newProduct(Product product){ return productRepository.save(product); }
    public Product productsBought(Long id, int qty) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent())
            if (product.get().productBought(qty)) {
                productRepository.delete(product.get());
                return null;
            } else
                return productRepository.save(product.get());
        return null;
    }
}
