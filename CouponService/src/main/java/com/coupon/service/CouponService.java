package com.coupon.service;

import com.coupon.model.Coupon;

import java.util.List;
import java.util.Optional;

public interface CouponService {

	Coupon save(Coupon deal);


	List<Coupon> findAll();



	String deleteById(String couponId);

	Optional<Coupon> findByCouponId(String couponId);


    boolean verifyCouponCode(String couponCode);
}
