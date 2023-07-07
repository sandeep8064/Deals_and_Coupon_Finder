package com.dealsandcouponsfinder.CartPayService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dealsandcouponsfinder.CartPayService.model.Addcart;
import com.microservice.ProductsService.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealsandcouponsfinder.CartPayService.exception.CartPayRequestException;
import com.dealsandcouponsfinder.CartPayService.model.Cart;
import com.dealsandcouponsfinder.CartPayService.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;

	@Autowired
    private ProductsService productsService; //feign

    public List<Products> getAllProducts()
    {
        Products[] products= productsService.getAllProducts().toArray(new Products[0]);
        return List.of(products);
    }

	public void storeProductInCart(Addcart addcart) {

		com.dealsandcouponsfinder.CartPayService.model.Products product = addcart.getProducts();
		Cart cart = addcart.getCart();

		// Add the product to the cart
		cart.setProducts(product);

		// Save the updated cart to the database
		cartRepository.save(cart);
	}

	public double calculateTotalPrice() {
		List<Cart> carts = cartRepository.findAll();
		double totalPrice = 0.0;

		for (Cart cart : carts) {
			com.dealsandcouponsfinder.CartPayService.model.Products product = cart.getProducts();
			totalPrice += product.getPrice();
		}
        totalPrice = Double.parseDouble(String.format("%.2f", totalPrice));
		return totalPrice;
	}







	public List<Cart> findAll() {
		return (List<Cart>) cartRepository.findAll();
	}

	public String deleteById(String id) {
		if (!findByCartId(id).isEmpty()) {
			cartRepository.deleteById(id);
			return "Id " + id + " deleted!";
		} else {
			return "Id " + id + " is not found";
		}
	}


	@Override
	public String deleteAllCart(String userId) {
		List<Cart> cart = cartRepository.findAll();
		for (Cart cart2 : cart) {
			deleteById(cart2.getCartId());
		}
		return "All deleted";
	}

	@Override
	public Optional<Cart> findByCartId(String cartId) {
		Optional<Cart> cart = cartRepository.findById(cartId);
		if (cart.isEmpty()) {
			throw new CartPayRequestException("Id is not found");
		} else {
			return cart;
		}
	}


}