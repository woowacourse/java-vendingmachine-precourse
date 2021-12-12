package vendingmachine.controller;

import vendingmachine.view.InputView;

public class ProductController {
	public void getProducts() {
		String products = InputView.getProducts();
		System.out.println(products);
	}
}
