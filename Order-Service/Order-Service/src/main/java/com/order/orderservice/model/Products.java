package com.order.orderservice.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {

	private String id;
	private String name;
	private double price;
	private double rating;
	private String imageUrl;
	private LocalDate dateOfExpiration;

}
