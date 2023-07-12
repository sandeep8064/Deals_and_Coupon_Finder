package com.microservice.ProductsService.controller;

import com.microservice.ProductsService.models.Products;
import com.microservice.ProductsService.service.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	ProductsServiceImpl productsServiceImpl;
	
	@GetMapping("/")
	public List<Products> getAllProducts() {
		return productsServiceImpl.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Object getProductById(@PathVariable String id) {
		return productsServiceImpl.getProductById(id);
	}
	
	@GetMapping("/find/category/{category}")
	public List<Optional<Products>> searchProductsByCategory(@PathVariable("category") String category) {
		List<Optional<Products>> coupon = productsServiceImpl.findByCategory(category);
		return coupon;
	}
	
	
	
	@PostMapping("/add")
	public Products addProduct(@RequestBody Products product) {
		return productsServiceImpl.addProduct(product);
	}
	
	@PutMapping("/update")
	public Products updateProduct(@RequestBody Products product) {
		return productsServiceImpl.updateProduct(product);
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteProductById(@PathVariable String id) {
		productsServiceImpl.deleteProductById(id);
	}
	
}