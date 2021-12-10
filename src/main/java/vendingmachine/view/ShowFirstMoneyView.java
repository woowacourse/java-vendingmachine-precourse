package vendingmachine.view;

import java.util.Map;

import vendingmachine.Application;
import vendingmachine.controller.ViewMappingKey;
import vendingmachine.domain.Coin;
import vendingmachine.util.SystemMessage;

public class ShowFirstMoneyView implements View {
	@Override
	public void show() {
		System.out.println(SystemMessage.SHOW_FIRST_MONEY);
		Map<Coin, Integer> coins = Application.controller.getCoins();
		printCoins(coins);
		Application.controller.view(ViewMappingKey.INPUT_ITEM_INFO);
	}

	private void printCoins(Map<Coin, Integer> coins) {
		coins.forEach(Coin::printCoinAndCount);
	}
}
