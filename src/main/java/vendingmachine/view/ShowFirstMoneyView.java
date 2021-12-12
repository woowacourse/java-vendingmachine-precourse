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
		printCoins();
		goInputItemInfoView();
	}

	private void printCoins() {
		Map<Coin, Integer> coins = Application.controller.getCoins();
		coins.forEach(Coin::printCoinAndCount);
	}

	private void goInputItemInfoView() {
		Application.controller.view(ViewMappingKey.INPUT_ITEM_INFO);
	}
}
