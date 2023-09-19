package com.jeffserson.grocery.manager.controller;

import java.util.List;
import java.util.Optional;

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
import com.jeffserson.grocery.manager.repositry.ProductRepository;

@RestController
public class ProductController {

	private ProductRepository productRepository;

	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@PostMapping("/newProduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) throws Exception {
		productRepository.save(product);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@GetMapping("/getProduct/{id}")
	public Product getProductById(@PathVariable Long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			return product.get();
		}
		return null;
	}

	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<HttpStatus> deleteProuctById(@PathVariable Long id) {
		productRepository.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity<HttpStatus> deleteAll() {
		productRepository.deleteAll();
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<Product> updateProductById(@PathVariable Long id, @RequestBody Product product) {
		Product pro = new Product();
		pro.setName(product.getName());
		pro.setCategory(product.getCategory());
		pro.setBarCode(product.getBarCode());
		pro.setExpirationDate(product.getExpirationDate());
		productRepository.save(product);
		return new ResponseEntity<Product>(pro, HttpStatus.OK);
	}

}
