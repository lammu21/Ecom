package com.ecom.productservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom.productservice.exceptions.ProductNotFoundException;
import com.ecom.productservice.model.Product;
import com.ecom.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
// @RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
 
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository=productRepository;
    }

    
    public List<Product> getAll()
    {
        return productRepository.findAll();

    }

    public Product getProdById(String id)
    {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    public Product addProduct(Product prod)
    {
        return productRepository.save(prod);
    }

    public Product updateProd(String id,Product product)
    {
        Product prod = productRepository.findById(id)
                       .orElseThrow(() -> new ProductNotFoundException("Product not found"));

           prod.setProductName(product.getProductName());
            prod.setCategory(product.getCategory());
            prod.setPrice(product.getPrice());
            prod.setQuantity(product.getQuantity());
            prod.setCurrency(product.getCurrency());
            prod.setDescription(product.getDescription());
            prod.setImages(product.getImages());
            prod.setSpecifications(product.getSpecifications());

            // ❗ don’t override createdAt
            prod.setUpdateAt(LocalDateTime.now());

            return productRepository.save(prod);

    }

    public void deleteProd(String id)
    {
        productRepository.deleteById(id);
    }

    
}
