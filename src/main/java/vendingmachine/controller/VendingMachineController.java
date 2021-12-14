package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	private final VendingMachine vendingMachine;

	public VendingMachineController() {
		OutputView.setVendingMachineMoney();
		vendingMachine = new VendingMachine(InputView.readPositiveInt());
		OutputView.showCoins(vendingMachine.getCoinStorageBox());
	}

	public void addItems() {
		OutputView.addItems();
		vendingMachine.addNewItems(InputView.readItems());
		OutputView.breakLine();
	}

	public void buyItems() {
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

	public void showVendingMachineCoins() {
		OutputView.showCoinStorageState(vendingMachine.getCoinStorageBox());
	}

	private boolean checkCanBuyProduct(int money) {
		return money >= vendingMachine.getNeedMinimumMoney();
	}
}