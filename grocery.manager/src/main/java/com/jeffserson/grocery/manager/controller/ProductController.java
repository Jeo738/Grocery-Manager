package com.jeffserson.grocery.manager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jeffserson.grocery.manager.entities.Product;
import com.jeffserson.grocery.manager.service.ProductService;

@RestController
public class ProductController {

  private ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("/newProduct")
  public ResponseEntity<Product> saveProduct(@RequestBody Product product) throws Exception {
    return productService.saveProduct(product);
  }

  @GetMapping("/getAllProducts")
  public List<Product> getAllProducts() {
    return productService.findAllProducts();
  }

  @GetMapping("/getProduct/{id}")
  public Product getProductById(@PathVariable Long id) {
    return productService.findProductById(id);
  }

  @DeleteMapping("/deleteProduct/{id}")
  public ResponseEntity<HttpStatus> deleteProuctById(@PathVariable Long id) {
    return productService.deleteProductById(id);
  }

  @DeleteMapping("/deleteAll")
  public ResponseEntity<HttpStatus> deleteAll() {
    return productService.deleteAllProducts();
  }

  @PutMapping("/updateProduct/{id}")
  public ResponseEntity<HttpStatus> updateProduct(@PathVariable Long id, @RequestBody Product product) {
    return productService.updateProductById(id, product);
  }

}
