package com.dealsandcouponsfinder.CartPayService.controller;

import com.dealsandcouponsfinder.CartPayService.model.Cart;
import com.dealsandcouponsfinder.CartPayService.repository.CartRepository;
import com.dealsandcouponsfinder.CartPayService.service.CartService;
import com.dealsandcouponsfinder.CartPayService.service.CouponService;
import com.dealsandcouponsfinder.CartPayService.service.ProductsService;
import com.microservice.ProductsService.models.Products;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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

	@Autowired
	CouponService couponService;
  //creating method which returns list of products
	@GetMapping("/seeproducts")
    public List<Products> getAllDetails() {
		log.info("got all details");
        return cartService.getAllProducts();
    }


	@GetMapping("/addtocart/{id}")
	public ResponseEntity<String> addProductToCart(@PathVariable String id) {
		try {
			// Get the product by its ID using the ProductService Feign client
			Object productResponse = productsService.getProductById(id);

			// Convert the product response to a Products object
			Products product = (Products) productResponse;

			if (product != null) {
				// Create a cart object and set the product
				Cart cart = new Cart();
				cart.setProducts(product);


				// Save the cart to the database
				cartRepository.save(cart);

				return ResponseEntity.ok("Product added to cart successfully.");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
			}
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


	@GetMapping("/discount/{coupon}")
	public double calculateDiscount(@PathVariable String coupon) {

		if(couponService.verifyCouponCode(coupon)) {

			// Extract the number from the coupon string
			String numberString = coupon.replaceAll("\\D+", ""); // Remove non-digit characters
			int discountPercentage = Integer.parseInt(numberString);
			double totalPrice = cartService.calculateTotalPrice();
			// Calculate the discount based on the extracted number
			double discount = 0.0;
			if (discountPercentage > 0 && discountPercentage <= 100) {
				discount = (discountPercentage / 100.0) * totalPrice; // Assuming totalPrice is a variable representing the total price of products in the cart
			}
			double price = Double.parseDouble(String.format("%.2f", totalPrice - discount));

			return price;
		}
		else
		{
			return 404;
		}
	}




}
