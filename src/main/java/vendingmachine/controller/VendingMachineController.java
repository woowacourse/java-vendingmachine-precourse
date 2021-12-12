package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	private final VendingMachine vendingMachine;

	public VendingMachineController() {
		vendingMachine = new VendingMachine(InputView.readPositiveInt());
		showVendingMachineCoins();
	}

	private void showVendingMachineCoins() {
		OutputView.showCoins(vendingMachine.getCoinsOwned());
	}

	public void addProduct() {
		OutputView.addProductAndNumbers();
		vendingMachine.addProduct(InputView.readLineString());
	}

	public void buyProduct() {
		OutputView.enterInputMoney();
		int money = InputView.readPositiveInt();
		while (checkCanBuyProduct(money)) {
			OutputView.showRemainingMoney(money);
			OutputView.enterWantProduct();
			String product = InputView.readLineString();
			money = vendingMachine.getProduct(product, money);
		}
	}

	public void showChange() {
		OutputView.showRemainingMoney(vendingMachine.getCoinsOwned());
	}

	private boolean checkCanBuyProduct(int money) {
		return money >= vendingMachine.getNeedMinimumMoney();
	}
}