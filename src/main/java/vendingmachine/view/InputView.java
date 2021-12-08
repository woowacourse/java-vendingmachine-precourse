package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.ViewMessage;
import vendingmachine.util.validator.MoneyValidator;

public class InputView {
	private final MoneyValidator moneyValidator;

	public InputView() {
		this.moneyValidator = new MoneyValidator();
	}

	public int enterMachineMoney() {
		while (true) {
			try {
				System.out.println(ViewMessage.INPUT_MACHINE_MONEY.getMessage());
				String input = Console.readLine();
				moneyValidator.MachineMoneyvalidate(input);
				return Integer.parseInt(input);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
