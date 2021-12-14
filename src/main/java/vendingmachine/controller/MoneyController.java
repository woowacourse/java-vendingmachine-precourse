package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MoneyController {
	private final InputView inputView;
	private final OutputView outputView;
	private Money money;

	public MoneyController(final InputView inputView, final OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void setupMoney() {
		money = giveMoney();
	}

	private Money giveMoney() {
		try {
			outputView.printInsertingMoneyRequest();
			return new Money(inputView.scanPrice());
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return giveMoney();
		}
	}

	public int getCurrentMoney() {
		return money.getMoney();
	}

	public void update(int moneyAmount) {
		money.pay(moneyAmount);
	}

}
