package com.dealsandcouponsfinder.CartPayService.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CouponService",url = "localhost:8081")
public interface CouponService {

    @GetMapping("coupon/verify/{couponCode}")
    public boolean verifyCouponCode(@PathVariable String couponCode);


}
