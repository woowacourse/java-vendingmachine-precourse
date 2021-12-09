package vendingmachine.domain;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachine {
	private CoinBox coinBox;

	public void start() {
		makeHoldingMoney();
	}

	private void makeHoldingMoney() {
		OutputView.printHoldingMoneyRequestMessage();
		int holdingMoney = getHoldingMoneyInput();
		coinBox = new CoinBox(holdingMoney);
	}

	private int getHoldingMoneyInput() {
		return Integer.parseInt(InputView.getHoldingMoneyInput());
	}
}
