package vendingmachine.controller;

import static vendingmachine.constant.ErrorMessage.*;
import static vendingmachine.exception.NumberException.*;
import static vendingmachine.exception.ProductException.*;
import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

import vendingmachine.model.Money;
import vendingmachine.model.Products;
import vendingmachine.service.CoinService;
import vendingmachine.service.ProductService;

public class VendingMachineController {

	Money possessionMoney;
	Money insertMoney;
	Products products;
	CoinService coinService = new CoinService();
	ProductService productService;

	public void run() {
		requestInput();
		setService();
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

	private void setService() {
		productService = new ProductService(products, insertMoney);
	}

	private void doShopping() {
		int minimumPrice = productService.getMinimumPrice();
		while (insertMoney.isMoneyBiggerThanValue(minimumPrice)
			&& productService.isOverZeroAllProductCount()) {
			reportInputMoney(insertMoney.getMoney());
			purchaseProduct();
		}
		reportInputMoney(insertMoney.getMoney());
	}

	private void purchaseProduct() {
		productService.purchase(inputProductName());
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
		if (!productService.canSell(productName)) {
			throw new IllegalArgumentException(PRODUCT_NOT_BUY_MSG);
		}
	}

	private void returnChange() {
		coinService.createGreedyCoin(insertMoney.getMoney());
		reportChangeCoin(coinService.getChangeCoins());
	}

}
