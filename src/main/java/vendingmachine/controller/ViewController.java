package vendingmachine.controller;

import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class ViewController {

	public static InputView inputView = new InputView();
	public static OutputView outputView = new OutputView();

	public int returnMoneyOfVendingMachine() {
		outputView.askInputMoneyOfVendingMachine();
		return inputView.getValidMoney();
	}

	public int returnDepositAmount() {
		outputView.askDepositAmount();
		int depositAmount = inputView.getValidMoney();
		outputView.printRemainingDeposit(depositAmount);

		return depositAmount;
	}

	public String returnProductList() {
		outputView.askProductInfo();
		return inputView.getProductsInput();
	}

	public String returnProductWantToBuy(VendingMachine vendingMachine) {
		outputView.askProductWantToBuy();
		return inputView.getProductWantToBuy(vendingMachine);
	}

	public void printRemainingDeposit(int deposit) {
		outputView.printRemainingDeposit(deposit);
	}
}
