package vendingmachine.view;

import java.util.LinkedHashMap;
import java.util.Map;

import vendingmachine.Application;
import vendingmachine.domain.Coin;
import vendingmachine.util.PublicConst;
import vendingmachine.util.SystemMessage;

public class ReturnChangesView implements View {
	@Override
	public void show() {
		int money = Application.controller.getMoney();
		printMoneyAndMessage(money);
		printChanges(money);
	}

	private void printMoneyAndMessage(int money) {
		System.out.println(SystemMessage.SHOW_INPUT_MONEY + money + PublicConst.MONETARY_UNIT);
		System.out.println(SystemMessage.RETURN_CHANGES);
	}

	private void printChanges(int money) {
		Map<Coin, Integer> changes = new LinkedHashMap<>();
		Map<Coin, Integer> coins = Application.controller.getCoins();

		calculateChanges(coins, changes, money);

		changes.forEach(Coin::printCoinAndCount);
	}

	private void calculateChanges(Map<Coin, Integer> coins, Map<Coin, Integer> changes, int money) {
		for (Coin coin : coins.keySet()) {
			int coinCount = coins.get(coin);

			if (coinCount == 0)
				continue;

			int changeCount = Math.min(coinCount, money / coin.getAmount());
			changes.put(coin, changeCount);
			money -= coin.getAmount() * changeCount;

			if (money == 0)
				break;
		}
	}
}
