package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	private final VendingMachine vendingMachine;

	public VendingMachineController() {
		OutputView.setVendingMachineMoney();
		vendingMachine = new VendingMachine(InputView.readPositiveInt());
		showVendingMachineCoins();
	}

	private void showVendingMachineCoins() {
		OutputView.showCoins(vendingMachine.getCoinStorage());
	}

	public void addProduct() {
		OutputView.addProductAndNumbers();
		vendingMachine.addNewItems(InputView.readItems());
		OutputView.breakLine();
	}

	public void buyProduct() {
		OutputView.enterInputMoney();
		int money = InputView.readPositiveInt();
		while (checkCanBuyProduct(money)) {
			OutputView.showRemainingMoney(money);
			OutputView.enterWantProduct();
			String product = InputView.readLineString();
			money = vendingMachine.getItem(product, money);
			OutputView.breakLine();
		}
	}

	public void showChange() {
		OutputView.showCoinStorageState(vendingMachine.getCoinStorage());
	}

	private boolean checkCanBuyProduct(int money) {
		return money >= vendingMachine.getNeedMinimumMoney();
	}
}