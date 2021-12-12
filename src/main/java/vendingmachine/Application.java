package vendingmachine;

import vendingmachine.controller.CoinController;
import vendingmachine.controller.ProductController;

public class Application {
	public static void main(String[] args) {
		CoinController coinController = new CoinController();
		ProductController productController = new ProductController();
		coinController.setVendingMachineCoinCounter();
		productController.getProducts();
	}
}
