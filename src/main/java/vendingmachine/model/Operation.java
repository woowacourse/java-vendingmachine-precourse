package vendingmachine.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.controller.BalanceController;
import vendingmachine.controller.ItemController;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.BalanceMessage;
import vendingmachine.view.ItemMessage;

public class Operation {

	public static VendingMachine turnOn() {
		BalanceMessage.printInputMessage();
		int balance = BalanceController.getInitialMoney();

		Map<Integer, Integer> coinMap = Coin.decideCoinRandomly(new LinkedHashMap<>(), balance);
		BalanceMessage.printCoinList(coinMap);

		ItemMessage.printSettingMessage();
		List<Item> itemList = Item.createList(ItemController.getInputItemForm());

		return VendingMachine.create(coinMap, itemList);
	}
}
