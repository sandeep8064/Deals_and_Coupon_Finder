package com.dealsandcouponsfinder.CartPayService.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dealsandcouponsfinder.CartPayService.exception.CartPayRequestException;
import com.dealsandcouponsfinder.CartPayService.model.Cart;
import com.dealsandcouponsfinder.CartPayService.repository.CartRepository;
import com.dealsandcouponsfinder.CartPayService.service.CartService;


@SpringBootTest
public class CartPayServiceTest {


	@Autowired
	private CartService cartService;

	@MockBean
	private CartRepository cartRepository;







}

