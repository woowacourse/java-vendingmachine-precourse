package vendingmachine.controller;

import java.util.Map;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Items;
import vendingmachine.domain.Money;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private static final InputView inputView = new InputView();
	private static final CoinController coinController = new CoinController(inputView);
	private static final ItemController itemcontroller = new ItemController(inputView);

	public void run() {

		Coins coins = coinController.giveHoldingCoins();
		Items items = itemcontroller.giveItems();
		Money money = giveMoney();
		sellItem(items, money);

		OutputView.printMoney(money);
		OutputView.printChanges(getChanges(coins, money));
	}

	private Money giveMoney() {
		try {
			OutputView.printInsertingMoneyRequest();
			return new Money(inputView.scanPrice());
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return giveMoney();
		}
	}

	private void sellItem(Items items, Money money) {
		while (money.payable(itemcontroller.getLeastItemCost(items))
			&& !items.checkAllOutOfOrder()) {
			try {
				itemcontroller.update(items, money);
			} catch (IllegalArgumentException e) {
				OutputView.printError(e.getMessage());
			}
		}
	}

	private Map<Integer, Integer> getChanges(Coins coins, Money money) {
		Map<Integer, Integer> changes = money.makeChanges(coins);
		coins.update(changes);
		return changes;
	}
}
