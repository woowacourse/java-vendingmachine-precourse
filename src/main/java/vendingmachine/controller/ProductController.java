package vendingmachine.controller;

import vendingmachine.service.ProductService;
import vendingmachine.view.InputView;

public class ProductController {

	private final ProductService productService = new ProductService();

	public ProductService getProductService() {
		return productService;
	}

	public void inputProduct() {
		String products;
		do {
			productService.deleteAll();
			products = InputView.inputProduct();
		} while (!productService.validateProduct(products));
	}
}
