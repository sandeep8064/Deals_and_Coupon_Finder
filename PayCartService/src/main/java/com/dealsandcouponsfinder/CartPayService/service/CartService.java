package com.dealsandcouponsfinder.CartPayService.service;

import java.util.List;
import java.util.Optional;

import com.dealsandcouponsfinder.CartPayService.model.Addcart;
import com.dealsandcouponsfinder.CartPayService.model.Cart;
import com.microservice.ProductsService.models.Products;

public interface CartService {


	public void storeProductInCart(Addcart addcart);

	List<Cart> findAll();

	String deleteById(String id);



	String deleteAllCart(String userId);

	Optional<Cart> findByCartId(String cartId);



	List<Products> getAllProducts();




	double calculateTotalPrice();
}