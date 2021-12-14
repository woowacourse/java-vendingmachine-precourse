package vendingmachine;

import vendingmachine.controller.CoinController;
import vendingmachine.controller.InputMoneyController;
import vendingmachine.controller.ProductController;

public class Application {
	private static InputMoneyController inputMoneyController;
	private static ProductController productController;
	private static CoinController coinController;

	public static void initialize() {
		inputMoneyController = new InputMoneyController();
		productController = new ProductController();
		coinController = new CoinController();
	}

	public static void main(String[] args) {
		initialize();
		inputMoneyController.inputVendingMachineMoney();
		coinController.makeChangeCoins();
		productController.inputProduct();
		inputMoneyController.inputUserMoney();
		productController.orderProductUntilValid();
		coinController.displayChangeCoinViews();
	}
}
