package vendingmachine.controller;

import java.util.ArrayList;
import java.util.Map;

import vendingmachine.domain.Beverage;
import vendingmachine.domain.Change;
import vendingmachine.domain.Coin;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
	private static final int itemIndex = 0;
	private static final int priceIndex = 1;
	private static final int stockIndex = 2;

	Beverage beverage;

	public void run() {
		Change change = new Change(InputView.getHavingMoney());
		Map<Coin, Integer> changes = change.generateChanges();
		OutputView.printHavingMoney();
		ArrayList<String> itemPriceStock = InputView.getItemPriceStock();
		splitItem(itemPriceStock);

	}

	private void splitItem(ArrayList<String> itemPriceStock) {
		for (String s : itemPriceStock) {
			String[] itemInfo = s.split(",");
			String name = itemInfo[itemIndex];
			int price = Integer.parseInt(itemInfo[priceIndex]);
			int stock = Integer.parseInt(itemInfo[stockIndex]);
			beverage = new Beverage(name, price, stock);

		}
	}

}
