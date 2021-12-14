package vendingmachine.controller;

import java.util.LinkedHashMap;
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
		Map<Integer, Integer> changes = getChanges(money.getMoney());
		outputView.printChanges(changes);

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

	public Map<Integer, Integer> getChanges(int moneyAmount) {
		Map<Integer, Integer> changes = new LinkedHashMap<>();
		Map<Integer, Integer> restCoins = coinController.getRestCoins();
		for (Map.Entry<Integer, Integer> coin : restCoins.entrySet()) {
			final int number = coinController.getAvailableChangeNumber(coin.getKey(), coin.getValue(), moneyAmount);
			final boolean isUpperThanZero = 0 < number;
			if (isUpperThanZero) {
				changes.put(coin.getKey(), number);
				money.pay(coin.getKey() * number);
			}
		}
		return changes;
	}
}
