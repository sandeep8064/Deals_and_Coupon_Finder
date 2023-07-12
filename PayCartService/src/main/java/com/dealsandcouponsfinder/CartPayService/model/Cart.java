package com.dealsandcouponsfinder.CartPayService.model;

import com.microservice.ProductsService.models.Products;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "CartDetails")
public class Cart {

	@Id
	private String cartId;

	private Products products;



}
