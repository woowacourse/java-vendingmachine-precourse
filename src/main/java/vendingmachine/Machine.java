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
	private final ItemParser itemParser;

	private Cashier cashier;
	private ItemManager itemManager;

	public Machine() {
		this.display = new Display();
		this.validator = new Validator();
		this.itemParser = new ItemParser();
	}

	public void run() {
		prepareCoins();
		prepareItems();
		prepareInsertAmount();
		display.printInsertAmount(cashier);
		// while (cashier.isInsertAmountEnough(itemManager.getMinPrice())) {
			itemManager.sellItem(askWhatToBuy());
		// }
		// TODO: 잔돈 반환
	}

	private void prepareCoins() {
		this.cashier = new Cashier(askHoldingAmount());
		display.printBlankLine();
		display.printAllCoin();
		display.printBlankLine();
	}

	private void prepareItems() {
		this.itemManager = new ItemManager(askItems());
		display.printBlankLine();
	}

	private void prepareInsertAmount() {
		cashier.insertMoney(askInsertAmount());
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

	private String askWhatToBuy() {
		display.askWhatToBuy();
		try {
			return validator.validateBuyingItem(Console.readLine(), itemManager);
		} catch (IllegalArgumentException e) {
			display.printError(e);
			return askWhatToBuy();
		}
	}
}
