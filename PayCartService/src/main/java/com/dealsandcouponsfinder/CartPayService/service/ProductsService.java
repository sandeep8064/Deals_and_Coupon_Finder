package com.dealsandcouponsfinder.CartPayService.service;


import com.microservice.ProductsService.models.Products;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ProductService",url = "localhost:8092")
public interface ProductsService {

    @GetMapping("/products/")
    public List<Products> getAllProducts();



    @GetMapping("products/{id}")
    public Products getProductById(@PathVariable String id);

}

