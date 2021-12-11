package vendingmachine.controller;

import java.util.List;

import vendingmachine.domain.Item;
import vendingmachine.domain.Items;
import vendingmachine.domain.Machine;
import vendingmachine.utils.ItemSeparator;
import vendingmachine.view.InputView;

public class MachineController {
	private InputView inputView = new InputView();

	public void run() {
		int machineMoney = inputView.enterMachineMoney();
		Machine machine = new Machine(machineMoney);
		machine.makeCoins();
		machine.printCoins();
		Items items = getItems();
		System.out.println(items);
	}

	private Items getItems() {
		String itemValues = inputView.enterItems();
		List<Item> items = ItemSeparator.separateItems(itemValues);
		return new Items(items);
	}

}
