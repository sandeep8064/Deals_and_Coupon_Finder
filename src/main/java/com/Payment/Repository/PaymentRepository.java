package com.Payment.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.razorpay.Payment;




public interface PaymentRepository extends MongoRepository<Payment, Integer> {

}
