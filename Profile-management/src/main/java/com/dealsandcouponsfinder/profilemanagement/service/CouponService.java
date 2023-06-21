package com.dealsandcouponsfinder.profilemanagement.service;

import com.coupon.model.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CouponsService",url ="localhost:8081")
public interface CouponService {

   @GetMapping("/coupon/find/userid/{userId}")
    List<Coupon> searchByUserId(@PathVariable  String userId);

}
