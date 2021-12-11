package vendingmachine.controller;

import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

import vendingmachine.model.InputMoney;
import vendingmachine.model.PossessionCoin;
import vendingmachine.model.PossessionMoney;
import vendingmachine.model.Products;

public class VendingMachineController {

	PossessionCoin possessionCoin = new PossessionCoin();
	PossessionMoney possessionMoney;
	InputMoney inputMoney;
	Products products;

	public void run() {
		inputPossession();
		inputProducts();
		doShopping();
	}

	private void inputProducts() {
		products = new Products(requestProduct());
	}

	public void inputPossession() {
		possessionMoney = new PossessionMoney(requestPossessionMoney());
		possessionCoin.createRandomCoins(possessionMoney);
		reportPossessionCoin(possessionCoin);
	}

	private void doShopping() {
		inputMoney = new InputMoney(requestInputMoney());
		int minimumPrice = products.getMinimumPrice();
		while (inputMoney.isBiggerThanPrice(minimumPrice) && products.isOverZeroAllProductCount()) {

		}
	}

}
