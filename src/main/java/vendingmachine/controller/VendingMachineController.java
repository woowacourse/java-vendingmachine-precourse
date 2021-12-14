package vendingmachine.controller;

import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.constant.ErrorMessage.*;
import static vendingmachine.exception.ProductException.*;
import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

import vendingmachine.model.Change;
import vendingmachine.model.Money;
import vendingmachine.model.PossessionCoin;
import vendingmachine.model.Products;

public class VendingMachineController {

	PossessionCoin possessionCoin = new PossessionCoin();
	Money possessionMoney;
	Money inputMoney;
	Products products;
	Change change;

	public void run() {
		inputPossession();
		inputProducts();
		inputMoney();
		doShopping();
		returnChange();
	}

	public void inputPossession() {
		possessionMoney = new Money(requestPossessionMoney());
		possessionCoin.createRandomCoins(possessionMoney);
		reportPossessionCoin(possessionCoin.getCoins());
	}

	private void inputProducts() {
		products = new Products(requestProduct());
	}

	private void inputMoney() {
		inputMoney = new Money(requestInputMoney());
	}

	private void doShopping() {
		int minimumPrice = products.getMinimumPrice();
		while (inputMoney.isMoneyBiggerThanValue(minimumPrice)
			&& products.isOverZeroAllProductCount()) {
			reportInputMoney(inputMoney.getMoney());
			purchaseProduct();
		}
		reportInputMoney(inputMoney.getMoney());
	}

	private void purchaseProduct() {
		products.purchase(inputProductName(), inputMoney);
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
		if (!products.canSell(productName, inputMoney)) {
			throw new IllegalArgumentException(PRODUCT_NOT_BUY_MSG);
		}
	}

	private void returnChange() {
		change = new Change();
		change.createGreedyCoin(possessionCoin, inputMoney.getMoney());
		reportChangeCoin(change.getCoins());
	}

}
