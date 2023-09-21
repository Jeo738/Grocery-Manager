package com.jeffserson.grocery.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jeffserson.grocery.manager.entities.Product;
import com.jeffserson.grocery.manager.repositry.ProductRepository;

@Service
public class ProductService {

  private ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public ResponseEntity<Product> saveProduct(Product product) {
    try {
      productRepository.save(product);
      return new ResponseEntity<Product>(HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  public List<Product> findAllProducts() {
    List<Product> products = null;
    try {
      products = productRepository.findAll();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return products;
  }

  public Product findProductById(Long id) {
    Product result = null;
    try {
      Optional<Product> product = productRepository.findById(id);
      if (product.isPresent()) {
        result = product.get();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  public ResponseEntity<HttpStatus> deleteProductById(Long id) {
    try {
      productRepository.deleteById(id);
      return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
  }

  public ResponseEntity<HttpStatus> deleteAllProducts() {
    try {
      productRepository.deleteAll();
      return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  public ResponseEntity<HttpStatus> updateProductById(Long id, Product product) {
    try {
      Optional<Product> pro = productRepository.findById(id);
      if (pro.isPresent()) {
        productRepository.save(setProductAtributes(pro));
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  public Product setProductAtributes(Optional<Product> pro) {
    Product result = new Product();
    result.setName(pro.get().getName());
    result.setCategory(pro.get().getCategory());
    result.setExpirationDate(pro.get().getExpirationDate());
    result.setBarCode(pro.get().getBarCode());
    return result;
  }

}
