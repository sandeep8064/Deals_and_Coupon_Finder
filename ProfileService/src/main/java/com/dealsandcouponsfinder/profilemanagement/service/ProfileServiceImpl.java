package com.dealsandcouponsfinder.profilemanagement.service;

import java.util.List;
import java.util.Optional;

import com.coupon.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dealsandcouponsfinder.profilemanagement.model.Profile;
import com.dealsandcouponsfinder.profilemanagement.repository.ProfileRepository;

@Service
@Component
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	private CouponService couponService;

	@Override
	public Profile save(Profile pro) {
		Profile profile = profileRepository.save(pro);
		return profile;
	}

	@Override
	public Optional<Profile> findById(String id) {
		Optional<Profile> profile = profileRepository.findById(id);
		return profile;

	}



	@Override
	public String deleteById(String id) {
		if (!findById(id).isEmpty()) {
			profileRepository.deleteById(id);
			return "Id " + id + " deleted!";
		} else {
			return "Id " + id + " is not found";
		}
	}

	@Override
	public List<Profile> findAll() {
		return (List<Profile>) profileRepository.findAll();
	}

	@Override
	public List<Coupon> searchByUserId(String userId) {

		List<Coupon> coupon = couponService.searchByUserId(userId);
		return  coupon;
	}




}
