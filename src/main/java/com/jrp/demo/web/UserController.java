package com.jrp.demo.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jrp.demo.domain.Product;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping ("/{userId}")
	public String displayUser (@PathVariable int userId) {
		return "User Found: " + userId;
	}
	
	
	@RequestMapping ("/{id}/invoices")
	public String displayUserInvoices (@PathVariable("id") int userId, 
			@RequestParam(value="d", required = false) Date dateOrNull) {
		return "invoice found for use: " + userId + " on the date: " + dateOrNull;
	}
	
	@RequestMapping ("/{userId}/items")
	public List<String> displayStringJson() {
		return Arrays.asList("Shoes", "Laptop", "button");
	}
	
	@RequestMapping ("/{userId}/products_as_json")
	public List<Product> displayProductsJson() {
		return Arrays.asList(new Product (1, "shoes", 42.99),
				new Product (1, "books", 12.99),
				new Product (1, "bag", 45.99));
	}
	
	//μόνο για ένα product και όχι για λίστα
	@RequestMapping ("/{userId}/product_as_json")
	public Product displayProductJson() {
		return new Product (1, "shoes", 42.99);
	}
	
}
