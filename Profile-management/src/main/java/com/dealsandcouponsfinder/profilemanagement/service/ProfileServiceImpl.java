package com.dealsandcouponsfinder.profilemanagement.service;

import java.util.Arrays;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dealsandcouponsfinder.profilemanagement.exception.ProfileRequestException;
import com.dealsandcouponsfinder.profilemanagement.model.Coupon;
import com.dealsandcouponsfinder.profilemanagement.model.Credentials;
import com.dealsandcouponsfinder.profilemanagement.model.Profile;
import com.dealsandcouponsfinder.profilemanagement.repository.CredentialsRepository;
import com.dealsandcouponsfinder.profilemanagement.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	CredentialsRepository credentialsRepository;

	@Autowired
    private RestTemplate restTemplate;
    String url2 = "http://Coupons/coupon" ;
    public List<Coupon> getAllProducts()
    {
        Coupon[] coupon=restTemplate.getForObject(url2+"/list",Coupon[].class);
        return (Arrays.asList(coupon));
    }
	public Profile save(Profile pro) {

		if (pro.getEmailId() == null && pro.getPassword() == null) {
			throw new ProfileRequestException("ID or password can not be null");
		} else {
			Profile profile = profileRepository.save(pro);
			Credentials cred = new Credentials(pro.getEmailId(), pro.getPassword());
			credentialsRepository.save(cred);
			return profile;
		}
	}

	public List<Profile> findAll() {
		return (List<Profile>) profileRepository.findAll();
	}

	public String deleteById(String id) {
		if (!findById(id).isEmpty()) {
			profileRepository.deleteById(id);
			return "Id " + id + " deleted!";
		} else {
			return "Id " + id + " is not found";
		}
	}

	public Optional<Profile> findById(String id) {
		Optional<Profile> profile = profileRepository.findById(id);
		if (profile.isEmpty()) {
			throw new ProfileRequestException("ID is not found");
		} else {
			return profile;
		}
	}

	public boolean login(Credentials credentials) {
		Optional<Credentials> storedCredentials = credentialsRepository.findByUsernameAndPassword(
				credentials.getUsername(),
				credentials.getPassword()
		);
		return storedCredentials.isPresent();
	}

	public boolean logout(Credentials cred) {
		Optional<Credentials> credentials = credentialsRepository.findById(cred.getUsername());
		if (credentials.isPresent() && credentials.get().getPassword().equals(cred.getPassword())
				) {

			credentialsRepository.save(credentials.get());
			return true;
		} else {
			return false;
		}
	}
}
