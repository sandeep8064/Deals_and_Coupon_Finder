package com.order.orderservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.orderservice.model.Order;
import com.order.orderservice.model.Payment;
import com.order.orderservice.model.Products;
import com.order.orderservice.repository.OrderRepository;



@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;




	@Autowired
    private RestTemplate restTemplate;
    String url3 = "http://Payment/payments" ;
    public List<Payment> getAllProducts()
    {
        Payment[] payment=restTemplate.getForObject(url3+"/list",Payment[].class);
        return (Arrays.asList(payment));
    }
	public List<Order> getAllOrders()
	{
	List<Order> orders = new ArrayList<Order>();
	orderRepository.findAll().forEach(orders1 -> orders.add(orders1));
	return orders;
	}


	public List<Order> getOrdersById(int userId)
	{
	return  orderRepository.findByUserId(userId);

	}


	public Order saveOrUpdate(Order orders)
	{
		return orderRepository.save(orders);

	}
	public void delete(String userId)
	{
		orderRepository.deleteById(userId);
	}

	public void update(Order orders, String userId)
	{
		orderRepository.save(orders);
	}

	public List<Order> getOrderByStatus(String orderStatus){
		return orderRepository.findByOrderStatus(orderStatus);
	}


	public Order updateOrderDetails(Order order) {
		String s = order.getOrderStatus();
		 System.out.println(s);
		 return orderRepository.save(order);
	}

	public String deleteOrderByOrderId(int orderId) {
		orderRepository.deleteByOrderId(orderId);
		return "Successfully Deleted";
	}
	public List<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		return null;
	}


}