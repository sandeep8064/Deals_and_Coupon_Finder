package com.microservice.ProductsService.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Products {

	@Id
	private String id;
	
	private String name;
	private double price;
    private String rating;
	private String imageUrl;
	private String category;
	

}