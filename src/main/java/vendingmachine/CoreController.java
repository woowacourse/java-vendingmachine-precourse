package vendingmachine;

import java.util.Map;

import coincase.CoinController;
import productcase.ProductController;
import ui.UiController;

public class CoreController {
	private CoinController coinController;
	private ProductController productController;
	private UiController uiController;

	CoreController() {
		coinController = new CoinController();
		productController = new ProductController();
		uiController = new UiController();
	}

	protected void setVendingMachineHoldMoney() {
		int money = uiController.askVendingMachineHoldMoneyAmount();
		Map<Coin, Integer> numberOfCoins = coinController.makeRandomCombinationCoin(money);
		uiController.printCurrentCoinNumber(numberOfCoins);
	}

	protected void setVendingMachineHoldProduct() {
		String products = uiController.askVendingMachineHoldProduct();
		productController.setNewProducts(products);
	}
}
