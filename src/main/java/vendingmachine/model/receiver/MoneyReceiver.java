package vendingmachine.model.receiver;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.validator.MoneyValidator;

public class MoneyReceiver {

	public static final String INIT_VALUE_OF_MONEY = "init";

	MoneyValidator moneyValidator = new MoneyValidator();

	public int receive() {
		String input = INIT_VALUE_OF_MONEY;

		boolean rewindSwitch = true;
		while (rewindSwitch) {
			input = Console.readLine();

			rewindSwitch = moneyValidator.validate(input);
		}

		return Integer.parseInt(input);
	}
}
