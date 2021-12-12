package vendingmachine.controller;

import vendingmachine.service.ProductService;
import vendingmachine.view.InputView;

public class ProductController {

	private static final ProductService productService = new ProductService();

	public void inputProduct() {
		String products;
		do {
			productService.deleteProducts();
			products = InputView.inputProduct();
		} while (!productService.validateProduct(products));
	}
}
