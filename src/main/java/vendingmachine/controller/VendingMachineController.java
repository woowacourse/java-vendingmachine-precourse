package vendingmachine.controller;

import static vendingmachine.constant.ErrorMessage.*;
import static vendingmachine.exception.NumberException.*;
import static vendingmachine.exception.ProductException.*;
import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

import vendingmachine.model.Money;
import vendingmachine.service.CoinService;
import vendingmachine.service.ShoppingService;

public class VendingMachineController {

	Money possessionMoney;
	CoinService coinService = new CoinService();
	ShoppingService shoppingService = new ShoppingService();

	public void run() {
		requestInput();
		doShopping();
		returnChange();
	}

	public void requestInput() {
		inputPossession();
		inputProducts();
		inputInsertMoney();
	}

	public void inputPossession() {
		possessionMoney = new Money(inputPossessionMoney());
		coinService.createRandomCoins(possessionMoney);
		reportPossessionCoin(coinService.getPossessionCoins());
	}

	public int inputPossessionMoney() {
		while (true) {
			String money = requestPossessionMoney();
			try {
				checkNumberException(money);
				return Integer.parseInt(money);
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

	private void inputProducts() {
		while (true) {
			String productList = requestProduct();
			try {
				checkProductException(productList);
				shoppingService.createProducts(productList);
				break;
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

	private void inputInsertMoney() {
		while (true) {
			String money = requestInsertMoney();
			try {
				checkNumberException(money);
				shoppingService.createInsertMoney(Integer.parseInt(money));
				break;
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

	private void doShopping() {
		while (shoppingService.canShopping()) {
			reportInputMoney(shoppingService.getInsertMoney());
			purchaseProduct();
		}
		reportInputMoney(shoppingService.getInsertMoney());
	}

	private void purchaseProduct() {
		shoppingService.purchase(inputProductName());
	}

	private String inputProductName() {
		while (true) {
			String productName = requestProductName();
			try {
				checkProductNameEmpty(productName);
				checkProductPurchase(productName);
				return productName;
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

	private void checkProductPurchase(String productName) {
		if (!shoppingService.canSell(productName)) {
			throw new IllegalArgumentException(PRODUCT_NOT_BUY_MSG);
		}
	}

	private void returnChange() {
		coinService.createGreedyCoin(shoppingService.getInsertMoney());
		reportChangeCoin(coinService.getChangeCoins());
	}

}
