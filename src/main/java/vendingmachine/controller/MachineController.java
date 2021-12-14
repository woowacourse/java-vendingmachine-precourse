package vendingmachine.controller;

import java.util.List;

import vendingmachine.domain.Item;
import vendingmachine.domain.Items;
import vendingmachine.domain.Machine;
import vendingmachine.utils.ItemSeparator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();

	public void run() {
		int machineMoney = inputView.enterMachineMoney();
		Machine machine = new Machine(machineMoney);
		machine.makeRandomCoins();
		outputView.printMachineCoins(machine);
		Items items = getItems();
		machine.setItems(items);
		activateMachine(machine);
	}

	private Items getItems() {
		String itemValues = inputView.enterItems();
		List<Item> items = ItemSeparator.separateItems(itemValues);
		return new Items(items);
	}

	private void activateMachine(Machine machine) {
		int inputMoney = inputView.enterInputMoney();
		inputMoney = sellItems(machine, inputMoney);
		outputView.printChanges(machine, inputMoney);
	}

	private int sellItems(Machine machine, int inputMoney) {
		while (inputMoney >= machine.getMinPrice() && machine.isStockNotEmpty()) {
			String buyItem = inputView.enterBuyItem(machine, inputMoney);
			machine.sellItem(buyItem);
			inputMoney -= machine.getPrice(buyItem);
		}
		return inputMoney;
	}

}
