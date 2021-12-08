package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.ViewMessage;
import vendingmachine.util.validator.ItemValidator;
import vendingmachine.util.validator.MoneyValidator;

public class InputView {
	private final MoneyValidator moneyValidator;
	private final ItemValidator itemValidator;

	public InputView() {
		this.moneyValidator = new MoneyValidator();
		this.itemValidator = new ItemValidator();
	}

	public int enterMachineMoney() {
		while (true) {
			try {
				System.out.println(ViewMessage.INPUT_MACHINE_MONEY.getMessage());
				String input = Console.readLine();
				moneyValidator.validateMoney(input);
				return Integer.parseInt(input);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public String enterItemInfo() {
		while (true) {
			try {
				System.out.println(ViewMessage.INPUT_ITEM_INFO.getMessage());
				String input = Console.readLine();
				itemValidator.validateItemInfo(input);
				return input;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public String enterPayMoney() {
		while (true) {
			try {
				System.out.println(ViewMessage.INPUT_PAY_MONEY.getMessage());
				String input = Console.readLine();
				moneyValidator.validateMoney(input);
				return input;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public String enterItemToBuy() {
		while (true) {
			try {
				System.out.println(ViewMessage.INPUT_ITEM_TO_BUY.getMessage());
				String input = Console.readLine();
				itemValidator.validateItemName(input);
				return input;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
