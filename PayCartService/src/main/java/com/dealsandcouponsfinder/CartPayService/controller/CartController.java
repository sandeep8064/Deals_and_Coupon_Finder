package com.dealsandcouponsfinder.CartPayService.controller;

import java.util.List;
import java.util.Optional;

import com.dealsandcouponsfinder.CartPayService.model.Addcart;
import com.dealsandcouponsfinder.CartPayService.repository.CartRepository;
import com.dealsandcouponsfinder.CartPayService.service.ProductsService;
import com.microservice.ProductsService.models.Products;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dealsandcouponsfinder.CartPayService.model.Cart;
import com.dealsandcouponsfinder.CartPayService.service.CartService;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {

	Logger log = LoggerFactory.getLogger(CartController.class);
	@Autowired
	CartService cartService;

	@Autowired
	CartRepository cartRepository;
	@Autowired
	ProductsService productsService;
  //creating method which returns list of products
	@GetMapping("/seeproducts")
    public List<Products> getAllDetails() {
		log.info("got all details");
        return cartService.getAllProducts();
    }

	@PostMapping("/addtocart")
	public ResponseEntity<String> addToCart(@RequestBody Addcart addcart) {
		try {
			// Extract the product and cart from the Addcart object
			com.dealsandcouponsfinder.CartPayService.model.Products product = addcart.getProducts();
			Cart cart = addcart.getCart();

			// Add the product to the cart
			cart.setProducts(product);

			// Save the updated cart to the database
			cartRepository.save(cart);

			return ResponseEntity.ok("Product added to cart successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while adding product to cart.");
		}
	}

	@GetMapping("/findall")
	public List<Cart> findCart() {
		log.info("to find all details");
		return (List<Cart>) cartService.findAll();
	}

	@DeleteMapping("/deleteCart/{id}")
	public String deleteCartById(@PathVariable("id") String id) {
		String result = cartService.deleteById(id);
		return result;
	}

	@GetMapping("/totalPrice")
	public double getTotalPrice() {
		return cartService.calculateTotalPrice();
	}





}
