package vendingmachine.controller;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class ViewController {

	public static InputView inputView = new InputView();
	public static OutputView outputView = new OutputView();

	public int returnMoneyOfVendingMachine() {
		outputView.askInputMoneyOfVendingMachine();
		return inputView.getMoneyOfVendingMachine();
	}

	public int returnDepositAmount() {
		outputView.askDepositAmount();
		int depositAmount = inputView.getDepositAmount();
		outputView.printRemainingDeposit(depositAmount);

		return depositAmount;
	}

	public String returnProductList() {
		outputView.askProductInfo();
		return inputView.getProductsInput();
	}

}
