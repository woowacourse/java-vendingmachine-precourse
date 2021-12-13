package vendingmachine;

import java.util.Map;

public class VendingMachine {
	private int insertAmount;
	private final Items items;
	private final Map<Coin, Integer> vendingMachineCoin;

	public VendingMachine(int insertAmount, Items items,
		Map<Coin, Integer> vendingMachineCoin) {
		this.insertAmount = insertAmount;
		this.items = items;
		this.vendingMachineCoin = vendingMachineCoin;
	}

	public boolean isBuyableMoreItem() {
		return (!items.isAmountAllZeroInItems() && items.isBuyable(insertAmount));
	}
}
