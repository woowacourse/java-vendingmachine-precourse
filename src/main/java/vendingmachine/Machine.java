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

	private Map<String, Item> items;
	private int insertAmount;

	public Machine() {
		this.display = new Display();
		this.validator = new Validator();
		this.cashier = new Cashier();
		this.itemParser = new ItemParser();
	}

	public void run() {
		prepareCoins();
		prepareItems();
		prepareInsertAmount();
		//TODO: 투입 금액이 상품의 최저가격보다 적으면 잔돈을 반환한다
	}

	private void prepareCoins() {
		cashier.makeCoins(askHoldingAmount());
		display.printBlankLine();
		display.printAllCoin();
		display.printBlankLine();
	}

	private void prepareItems() {
		this.items = askItems();
		display.printBlankLine();
	}

	private void prepareInsertAmount() {
		this.insertAmount = askInsertAmount();
		display.printBlankLine();
	}

	private int askInsertAmount() {
		display.askInsertAmount();
		try {
			return validator.validateAmount(Console.readLine());
		} catch (IllegalArgumentException e) {
			display.printError(e);
			return askInsertAmount();
		}
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
