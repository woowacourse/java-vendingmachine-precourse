package vendingmachine.domain;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachine {

	public void start() {
		makeHoldingMoney();
	}

	private void makeHoldingMoney() {
		OutputView.printHoldingMoneyRequestMessage();
		int holdingMoney = getHoldingMoneyInput();
	}

	private int getHoldingMoneyInput() {
		return Integer.parseInt(InputView.getHoldingMoneyInput());
	}
}
