package vendingmachine.domain;

import java.util.List;
import java.util.Map;

public class VendingMachine {
	private final Map<Coin, Integer> coinMap;
	private final List<Item> itemList;

	private VendingMachine(Map<Coin, Integer> coinMap, List<Item> itemList) {
		this.coinMap = coinMap;
		this.itemList = itemList;
	}
}
