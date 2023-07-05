package com.dealsandcouponsfinder.profilemanagement.service;

import java.util.List;
import java.util.Optional;

import com.dealsandcouponsfinder.profilemanagement.model.Credentials;
import com.dealsandcouponsfinder.profilemanagement.model.Profile;
import com.dealsandcouponsfinder.profilemanagement.repository.CredentialsRepository;

public interface ProfileService {

	Profile save(Profile pro);

	Optional<Profile> findById(String id);

	String deleteById(String id);

	public boolean login(Credentials credentials);

	boolean logout(Credentials cred);

	List<Profile> findAll();

}
