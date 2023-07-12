package com.coupon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Coupon")
public class Coupon {
	@Id
	private String couponId;


	@Field
	private String category;
	@Field
	private String code;
	@Field
	private String offer;
	@Field
	private String companyName;
	@Field
	private String imageUrl;


	
}
