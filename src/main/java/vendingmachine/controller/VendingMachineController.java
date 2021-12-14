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

	public void run() {

		coinController.setupHoldingCoins();
		itemcontroller.setupItems();
		Money money = giveMoney();
		sellItem(items, money);

		outputView.printMoney(money);
		outputView.printChanges(coinController.getChanges(coins, money));
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

	private void sellItem(final Items items, final Money money) {
		while (money.payable(itemcontroller.getLeastItemCost(items))
			&& !items.checkAllOutOfOrder()) {
			try {
				itemcontroller.update(items, money);
			} catch (IllegalArgumentException e) {
				outputView.printError(e.getMessage());
			}
		}
	}
}
