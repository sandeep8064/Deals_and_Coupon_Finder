package com.dealsandcouponsfinder.CartPayService.controller;

import java.util.List;
import java.util.Optional;

import com.dealsandcouponsfinder.CartPayService.service.ProductsService;
import com.microservice.ProductsService.models.Products;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealsandcouponsfinder.CartPayService.model.Cart;
import com.dealsandcouponsfinder.CartPayService.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	Logger log = LoggerFactory.getLogger(CartController.class);
	@Autowired
	CartService cartService;

	@Autowired
	ProductsService productsService;
  //creating method which returns list of products
	@GetMapping("/seeproducts")
    public List<Products> getAllDetails() {
		log.info("got all details");
        return cartService.getAllProducts();
    }

	@PostMapping("/addCart")
	public Cart addCart(@RequestBody Cart cart) {
		Cart cart1 = cartService.save(cart);
		return cart1;
	}

	@GetMapping("/find/cartId/{cartId}")
	public Optional<Cart> searchCartByCartId(@PathVariable("cartId") String cartId) {
		Optional<Cart> cart = cartService.findByCartId(cartId);
		log.info("find cart details");
		return cart;
	}

	@GetMapping("/find/userId/{userId}")
	public List<Optional<Cart>> searchCartByUserId(@PathVariable("userId") String userId) {
		List<Optional<Cart>> cart2 = cartService.findByUserId(userId);
		log.info("to find userId" +userId + "is available");
		return cart2;
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

	@GetMapping("/totalPrice/{userId}")
	    public double getTotalPrice(@PathVariable("userId") String userId) {
	        double result=cartService.getTotalPrice(userId);
	    	return result;
	        }

	@DeleteMapping("/deleteAllCart/{userId}")
	public String deleteAllCart(@PathVariable("userId") String userId) {
		String result=cartService.deleteAllCart(userId);
		return result;
	}

	@PutMapping("/updateCart")
	public Cart updateCart(@RequestBody Cart cart) {
		Cart cart1 = cartService.save(cart);
		return cart1;
	}

}
