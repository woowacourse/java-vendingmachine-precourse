package vendingmachine.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.controller.BalanceController;
import vendingmachine.controller.ItemController;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.view.BalanceMessage;
import vendingmachine.view.ItemMessage;

public class Operation {

	public static void turnOn() {
		BalanceMessage.printInputMessage();
		int balance = BalanceController.getInputValue();

		Map<Coin, Integer> coinMap = Coin.decideCoinRandomly(new HashMap<>(), Coin.values(), balance);
		BalanceMessage.printCoinList(coinMap);

		ItemMessage.printInputMessage();
		List<Item> itemList = Item.createList(ItemController.getInputValue());
	}
}
