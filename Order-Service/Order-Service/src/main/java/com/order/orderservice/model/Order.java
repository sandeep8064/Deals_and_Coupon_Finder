package com.order.orderservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection="order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Order {
	@Id
	private int orderId;

	private int userId;
	private String orderStatus;
	private double total;
	public String getOrderStatus() {
		// TODO Auto-generated method stub
		return null;
	}
}