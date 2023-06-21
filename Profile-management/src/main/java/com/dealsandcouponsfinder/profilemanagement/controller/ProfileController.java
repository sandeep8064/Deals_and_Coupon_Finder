package com.dealsandcouponsfinder.profilemanagement.controller;

import com.coupon.model.Coupon;
import com.dealsandcouponsfinder.profilemanagement.model.Profile;
import com.dealsandcouponsfinder.profilemanagement.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	ProfileService profileService;


	@PostMapping("/add")
	public Profile addProfile(@RequestBody Profile pro) {
		Profile profile = profileService.save(pro);
		return profile;
	}

	@GetMapping("/find/{id}")
	public Optional<Profile> searchProfileById(@PathVariable("id") String id) {
		Optional<Profile> profile = profileService.findById(id);
		return profile;
	}

	@GetMapping("/seecoupon/{userId}")
	public List<Coupon> searchByUserId(@PathVariable String userId) {

		return profileService.searchByUserId(userId);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteProfileById(@PathVariable("id") String id) {
		String result = profileService.deleteById(id);
		return result;
	}

	@GetMapping("/findall")
	public List<Profile> findProfiles() {
		return (List<Profile>) profileService.findAll();
	}


	@PutMapping("/update/{Id}")
	public Profile updateProfile(@PathVariable String Id,@RequestBody Profile pro) {
		Profile profile = profileService.save(pro);
		return profile;
	}

}