package vendingmachine.controller;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class ViewController {

	public static InputView inputView = new InputView();
	public static OutputView outputView = new OutputView();

	public int returnMoney() {
		outputView.askInputMoneyOfVendingMachine();
		return inputView.getMoneyOfVendingMachine();
	}

}
