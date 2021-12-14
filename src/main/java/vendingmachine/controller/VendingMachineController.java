package vendingmachine.controller;

import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.constant.ErrorMessage.*;
import static vendingmachine.exception.NumberException.*;
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
	Money insertMoney;
	Products products;
	Change change;

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
		possessionCoin.createRandomCoins(possessionMoney);
		reportPossessionCoin(possessionCoin.getCoins());
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
				products = new Products(productList);
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
				insertMoney = new Money(Integer.parseInt(money));
				break;
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

	private void doShopping() {
		int minimumPrice = products.getMinimumPrice();
		while (insertMoney.isMoneyBiggerThanValue(minimumPrice)
			&& products.isOverZeroAllProductCount()) {
			reportInputMoney(insertMoney.getMoney());
			purchaseProduct();
		}
		reportInputMoney(insertMoney.getMoney());
	}

	private void purchaseProduct() {
		products.purchase(inputProductName(), insertMoney);
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
		if (!products.canSell(productName, insertMoney)) {
			throw new IllegalArgumentException(PRODUCT_NOT_BUY_MSG);
		}
	}

	private void returnChange() {
		change = new Change();
		change.createGreedyCoin(possessionCoin, insertMoney.getMoney());
		reportChangeCoin(change.getCoins());
	}

}
