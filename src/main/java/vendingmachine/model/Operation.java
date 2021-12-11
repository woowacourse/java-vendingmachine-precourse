package vendingmachine.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.controller.BalanceController;
import vendingmachine.controller.ConsumerController;
import vendingmachine.controller.ItemController;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Consumer;
import vendingmachine.domain.Item;
import vendingmachine.view.BalanceMessage;
import vendingmachine.view.ConsumerMessage;
import vendingmachine.view.ItemMessage;

public class Operation {

	public static void turnOn() {
		BalanceMessage.printInputMessage();
		int balance = BalanceController.getInputValue();

		Map<Coin, Integer> coinMap = Coin.decideCoinRandomly(new LinkedHashMap<>(), Coin.values(), balance);
		BalanceMessage.printCoinList(coinMap);

		ItemMessage.printInputMessage();
		List<Item> itemList = Item.createList(ItemController.getInputValue());

		ConsumerMessage.printInputMessage();
		Consumer consumer = Consumer.create(ConsumerController.getInputValue());
	}
}
