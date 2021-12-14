package vendingmachine.controller;

import vendingmachine.repository.Products;

public class VendingMachineController {
	CoinController coinController = new CoinController();
	ProductController productController = new ProductController();
	OrderController orderController = new OrderController();

	public void run() {
		coinController.generate();
		Products products = productController.generate();
		orderController.get(products);
	}
}