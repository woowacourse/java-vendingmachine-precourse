package vendingmachine.controller;

import java.util.Map;

import vendingmachine.utils.ChangeCalculation;
import vendingmachine.utils.VendingMachineCoinGenerator;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.domain.Items;
import vendingmachine.views.InputView;
import vendingmachine.views.OutputView;

public class VendingMachine {
	private int insertAmount;
	private final Items items;
	private final Map<Coin, Integer> vendingMachineCoin;
	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();

	public VendingMachine() {
		vendingMachineCoin = VendingMachineCoinGenerator.generateVendingMachineCoin(
			inputView.getInputOfVendingMachineMoney());
		outputView.printVendingMachineCoin(vendingMachineCoin);
		items = inputView.getInputOfItems();
		insertAmount = inputView.getInputOfInsertAmount();
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
