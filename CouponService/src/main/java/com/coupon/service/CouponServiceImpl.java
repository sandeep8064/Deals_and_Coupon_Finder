package com.coupon.service;

import com.coupon.exception.CouponRequestException;
import com.coupon.model.Coupon;
import com.coupon.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponServiceImpl implements CouponService {
	@Autowired
	CouponRepository couponRepository;

	public Coupon save(Coupon deal) {
		Coupon coupon = couponRepository.save(deal);
		return coupon;
	}

	public List<Coupon> findAll() {
		return (List<Coupon>) couponRepository.findAll();
	}

	public Optional<Coupon> findByCouponId(String couponId) {
		Optional<Coupon> coupon = couponRepository.findById(couponId);
		if (coupon.isEmpty()) {
			throw new CouponRequestException("Id is not found");
		} else {
			return coupon;
		}
	}








	public String deleteById(String id) {
		if (!findByCouponId(id).isEmpty()) {
			couponRepository.deleteById(id);
			return "Id " + id + " deleted!";
		} else {
			return "Id " + id + " is not found";
		}
	}




	public boolean verifyCouponCode(String couponCode) {
		try {
			Coupon coupon = couponRepository.findByCode(couponCode)
					.orElseThrow(() -> new CouponRequestException("Coupon code not found"));
			return true;
		} catch (CouponRequestException e) {
			return false;
		}
	}



}
