package com.bootcamp.project.service;

import com.bootcamp.project.exception.ProjectException;
import com.bootcamp.project.model.Product;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.repos.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public Product updateProduct(Long productID, String name, String brand, String price){
        var product = findProductById(productID);
        if (product == null)
            throw new ProjectException("product not found");
        if (!name.isEmpty())
            product.setName(name);
        if (!brand.isEmpty())
            product.setBrand(brand);
        if (!price.isEmpty())
            product.setPrice(new BigDecimal(price));
        return save(product);
    }
    public Product getProductByID(Long id){
        var product = productRepository.findProductByProductID(id);
        if (product.isEmpty())
            throw new ProjectException("Product not Found");
        return product.get();
    }
}
