package vendingmachine;

import java.util.Map;

import coincase.CoinController;
import productcase.ProductController;
import ui.UiController;

public class CoreController {
	private int inputMoney;
	private CoinController coinController;
	private ProductController productController;
	private UiController uiController;

	CoreController() {
		inputMoney = 0;
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

	protected void setInputMoney() {
		inputMoney = uiController.askInputMoney();
	}
}
