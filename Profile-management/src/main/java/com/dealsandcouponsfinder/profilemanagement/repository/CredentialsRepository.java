package com.dealsandcouponsfinder.profilemanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.dealsandcouponsfinder.profilemanagement.model.Credentials;

import java.util.Optional;

public interface CredentialsRepository extends MongoRepository<Credentials, String> {

    Optional<Credentials> findByUsernameAndPassword(String username, String password);
}
