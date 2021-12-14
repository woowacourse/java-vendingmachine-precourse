package vendingmachine.controller;

import vendingmachine.repository.Products;
import vendingmachine.service.OrderService;

public class OrderController {

	OrderService orderService = new OrderService();

	public void get(Products products) {
		orderService.get(products);
	}
}