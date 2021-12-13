package vendingmachine;

import java.util.Map;

import coincase.CoinController;
import productcase.ProductController;
import ui.UiController;

public class CoreController {
	private static final int FAIL_TO_BUY = -1;

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

	private void setVendingMachineHoldMoney() {
		int money = uiController.askVendingMachineHoldMoneyAmount();
		Map<Coin, Integer> numberOfCoins = coinController.makeRandomCombinationCoin(money);
		uiController.printCurrentCoinNumber(numberOfCoins);
	}

	private void setVendingMachineHoldProduct() {
		String products = uiController.askVendingMachineHoldProduct();
		productController.setNewProducts(products);
	}

	private void setInputMoney() {
		inputMoney = uiController.askInputMoney();
	}

	private String getValidProductName() {
		String productName = "";
		uiController.printRemainMoney(inputMoney);
		productName = uiController.askProductNameToBuy();
		return productName;
	}

	private void buyProduct() {
		int remainMoney = 0;
		boolean endCondition = false;
		while (!endCondition) {
			String productName = getValidProductName();
			try {
				remainMoney = productController.buyProduct(productName, inputMoney);
				endCondition = true;
			} catch (IllegalArgumentException e) {
				uiController.printLogicalExceptionError(e.getMessage());
			}
		}
		inputMoney = remainMoney;
	}

	private void giveChange() {
		uiController.printRemainMoney(inputMoney);
		Map<Coin, Integer> change = coinController.getChange(inputMoney);
		uiController.printChange(change);
	}

	private boolean checkTerminateCondition() {
		return (productController.checkAllSoldOut()
			|| productController.checkImpossibleToBuyAnything(inputMoney));
	}

	protected void activateVendingMachine() {
		setVendingMachineHoldMoney();
		setVendingMachineHoldProduct();
		setInputMoney();
		while (!checkTerminateCondition()) {
			buyProduct();
		}
		giveChange();
	}
}
