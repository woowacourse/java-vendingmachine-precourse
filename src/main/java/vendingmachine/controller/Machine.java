package vendingmachine.controller;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.cash.service.Cashier;
import vendingmachine.model.item.domain.Item;
import vendingmachine.model.item.service.ItemManager;
import vendingmachine.model.item.service.ItemParser;
import vendingmachine.model.shared.Validator;
import vendingmachine.view.Display;

/**
 * 자판기의 처리 흐름을 제어하는 controller class
 *
 * @author YJGwon
 * @version 1.0
 * @since 1.0
 */
public class Machine {
	private final Display display;
	private final ItemParser itemParser;

	private Cashier cashier;
	private ItemManager itemManager;

	public Machine() {
		this.display = new Display();
		this.itemParser = new ItemParser();
	}

	public void run() {
		prepareCoins();
		prepareItems();
		prepareInsertAmount();
		sellItems();
		display.printChanges(cashier.getChanges());
	}

	private void prepareCoins() {
		prepareCashier();
		display.printBlankLine();
		display.printAllCoin();
		display.printBlankLine();
	}

	private void prepareItems() {
		this.itemManager = new ItemManager(listItems());
		display.printBlankLine();
	}

	private void prepareInsertAmount() {
		insertMoney();
		display.printBlankLine();
	}

	private void sellItems() {
		display.printInsertAmount(cashier);
		while (!itemManager.isAllSoldOut() && cashier.isInsertAmountEnough(itemManager.getMinPrice())) {
			cashier.payItem(askWhatToBuy());
			display.printBlankLine();
			display.printInsertAmount(cashier);
		}
	}

	private void prepareCashier() {
		display.askHoldingAmount();
		try {
			this.cashier = new Cashier(Validator.stringToInteger(Console.readLine()));
		} catch (IllegalArgumentException e) {
			display.printError(e);
			prepareCashier();
		}
	}

	private List<Item> listItems() {
		display.askItems();
		try {
			return itemParser.listFrom(Console.readLine());
		} catch (IllegalArgumentException e) {
			display.printError(e);
			return listItems();
		}
	}

	private void insertMoney() {
		display.askInsertAmount();
		try {
			cashier.insertMoney(Validator.stringToInteger(Console.readLine()));
		} catch (IllegalArgumentException e) {
			display.printError(e);
			insertMoney();
		}
	}

	private Item askWhatToBuy() {
		display.askWhatToBuy();
		try {
			return itemManager.takeOne(Console.readLine());
		} catch (IllegalArgumentException e) {
			display.printError(e);
			return askWhatToBuy();
		}
	}
}
