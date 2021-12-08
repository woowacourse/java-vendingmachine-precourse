package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.ViewMessage;
import vendingmachine.util.validator.ItemInfoValidator;
import vendingmachine.util.validator.MoneyValidator;

public class InputView {
	private final MoneyValidator moneyValidator;
	private final ItemInfoValidator itemInfoValidator;

	public InputView() {
		this.moneyValidator = new MoneyValidator();
		this.itemInfoValidator = new ItemInfoValidator();
	}

	public int enterMachineMoney() {
		while (true) {
			try {
				System.out.println(ViewMessage.INPUT_MACHINE_MONEY.getMessage());
				String input = Console.readLine();
				moneyValidator.validateMachineMoney(input);
				return Integer.parseInt(input);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public String enterItemInfo(){
		while (true) {
			try {
				System.out.println(ViewMessage.INPUT_MACHINE_MONEY.getMessage());
				String input = Console.readLine();
				itemInfoValidator.validateItemInfo(input);
				System.out.println(input);
				return input;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
