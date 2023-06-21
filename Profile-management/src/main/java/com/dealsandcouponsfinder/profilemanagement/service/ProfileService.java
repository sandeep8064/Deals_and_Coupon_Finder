package com.dealsandcouponsfinder.profilemanagement.service;

import java.util.List;
import java.util.Optional;

import com.coupon.model.Coupon;
import com.dealsandcouponsfinder.profilemanagement.model.Profile;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProfileService {

	Profile save(Profile pro);

	Optional<Profile> findById(String id);

	String deleteById(String id);

	List<Profile> findAll();

	List<Coupon> searchByUserId( String userId);
}
