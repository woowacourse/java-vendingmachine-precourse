package vendingmachine.controller;

import java.util.Map;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Items;
import vendingmachine.domain.Money;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();
	private static final CoinController coinController = new CoinController(inputView, outputView);
	private static final ItemController itemcontroller = new ItemController(inputView, outputView);
	private Money money;

	public void run() {

		coinController.setupHoldingCoins();
		itemcontroller.setupItems();
		this.money = giveMoney();
		sellItem(money.getMoney());

		outputView.printMoney(money.getMoney());
		outputView.printChanges(coinController.getChanges(coins, money.getMoney()));
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

	private void sellItem(int money) {
		while (this.money.getMoney() >= itemcontroller.getLeastItemCost()
			&& !itemcontroller.checkAllOutOfOrder()) {
			try {
				itemcontroller.update(money);
			} catch (IllegalArgumentException e) {
				outputView.printError(e.getMessage());
			}
		}
	}
}
