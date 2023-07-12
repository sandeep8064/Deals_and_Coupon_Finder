package com.coupon.controller;

import com.coupon.model.Coupon;
import com.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/coupon")
public class CouponController {

	@Autowired
	CouponService couponService;


	@PostMapping("/add")
	public Coupon addCoupon(@RequestBody Coupon deal) {
		Coupon coupon = couponService.save(deal);
		return coupon;
	}

	@GetMapping("/verify/{couponCode}")
	public boolean verifyCouponCode(@PathVariable String couponCode) {
		return couponService.verifyCouponCode(couponCode);
	}


	@GetMapping("/find/id/{couponId}")
	public Optional<Coupon> searchCouponByCouponId(@PathVariable("couponId") String couponId) {
		Optional<Coupon> coupon = couponService.findByCouponId(couponId);
		return coupon;
	}





	@DeleteMapping("/delete/id/{couponId}")
	public String deleteCouponBycouponId(@PathVariable("couponId") String couponId) {
		String result = couponService.deleteById(couponId);
		return result;
	}




	@GetMapping("/findall")
	public List<Coupon> findCoupon() {
		return (List<Coupon>) couponService.findAll();
	}

	@PutMapping("/update/couponId/{couponId}")
	public Coupon updateCoupon(@PathVariable String couponId,@RequestBody Coupon deal) {
		deal.setCouponId(couponId);
		Coupon coupon = couponService.save(deal);
		return coupon;
	}
}
