package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	private final VendingMachine vendingMachine;

	public VendingMachineController() {
		OutputView.setVendingMachineMoney();
		vendingMachine = new VendingMachine(InputView.readLineInt());
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
		int money = InputView.readLineInt();
		while (checkCanBuyProduct(money)) {
			OutputView.showRemainingMoney(money);
			OutputView.enterWantProduct();
			String product = InputView.readLineString();
			money = vendingMachine.getProduct(product, money);
		}
	}

	private boolean checkCanBuyProduct(int money) {
		return money >= vendingMachine.getNeedMinimumMoney();
	}
}