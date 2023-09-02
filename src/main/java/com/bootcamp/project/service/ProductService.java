package com.bootcamp.project.service;

import com.bootcamp.project.exception.ProjectException;
import com.bootcamp.project.model.Product;
import com.bootcamp.project.model.ShoppingList;
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

    public Product newProduct(Product product){
        return productRepository.save(product); }
    public Product productBought(Long id, int qty) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty())
            throw new ProjectException("Product not Fount");
        return productRepository.save(product.get().productBought(qty));
    }
    public List<Product> getAllProductsOfShoppingList(ShoppingList shopList){
        return shopList.getProducts();
    }
    public Product findProductById(Long id) {
        if (productRepository.findById(id).isEmpty())
            throw new ProjectException("Product not Fount");
        return productRepository.findById(id).get();
    }
    public Product save(Product product){
        return productRepository.save(product);
    }
}
