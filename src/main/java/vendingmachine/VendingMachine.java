package vendingmachine;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class VendingMachine {
	private int insertAmount;
	private final Items items;
	private final Map<Coin, Integer> vendingMachineCoin;
	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();

	public VendingMachine(int insertAmount, Items items,
		Map<Coin, Integer> vendingMachineCoin) {
		this.insertAmount = insertAmount;
		this.items = items;
		this.vendingMachineCoin = vendingMachineCoin;
	}

	public void run() {
		while (true) {
			buyItem();
			if (!isBuyableMoreItem()) {
				break;
			}
		}
		System.out.println();
		outputView.printInsertAmountRemaining(insertAmount);
		outputView.printChange(ChangeCalculation.calculateChange(vendingMachineCoin, insertAmount));
	}

	private void buyItem() {
		System.out.println();
		outputView.printInsertAmountRemaining(insertAmount);
		Item buyingItem = inputView.getInputOfBuyingItem(items, insertAmount);
		insertAmount = buyingItem.sell(insertAmount);
	}

	private boolean isBuyableMoreItem() {
		return (!items.isAmountAllZeroInItems() && items.isBuyable(insertAmount));
	}
}
