package vendingmachine;

import java.util.Map;

import camp.nextstep.edu.missionutils.Console;

/**
 * 자판기의 처리 흐름을 제어하는 controller class
 *
 * @author YJGwon
 * @version 1.0
 * @since 1.0
 */
public class Machine {
	private final Display display;
	private final Validator validator;
	private final Cashier cashier;
	private final ItemParser itemParser;

	public Machine() {
		this.display = new Display();
		this.validator = new Validator();
		this.cashier = new Cashier();
		this.itemParser = new ItemParser();
	}

	public void run() {
		prepareCoins();
		prepareItems();
	}

	private void prepareCoins() {
		cashier.makeCoins(askHoldingAmount());
		display.printBlankLine();
		display.printAllCoin();
		display.printBlankLine();
	}

	private void prepareItems() {
		askItems();
	}

	private int askHoldingAmount() {
		display.askHoldingAmount();
		try {
			return validator.validateAmount(Console.readLine());
		} catch (IllegalArgumentException e) {
			display.printError(e);
			return askHoldingAmount();
		}
	}

	private Map<String, Item> askItems() {
		display.askItems();
		try {
			return itemParser.stringToItems(Console.readLine());
		} catch (IllegalArgumentException e) {
			display.printError(e);
			return askItems();
		}
	}
}
