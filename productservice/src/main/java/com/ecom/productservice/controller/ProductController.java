package com.ecom.productservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.productservice.model.Product;
import com.ecom.productservice.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
// @RequiredArgsConstructor
public class ProductController
{
    private final ProductService productService;

    public ProductController(ProductService productService)
    {
      this.productService=productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll()
    {
      return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable String id)
    {
       return  ResponseEntity.ok(productService.getProdById(id));
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product prod)

    {
        Product product = productService.addProduct(prod);

        return  ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product prod)
    {
      Product product = productService.updateProd(id, prod);

      return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id)
    {
       productService.deleteProd(id);

       return ResponseEntity.noContent().build();
    }

    


}
