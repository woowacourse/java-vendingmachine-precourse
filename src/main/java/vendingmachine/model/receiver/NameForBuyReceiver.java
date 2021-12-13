package vendingmachine.model.receiver;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.validator.NameForBuyValidator;

public class NameForBuyReceiver {

	public static final String INIT_VALUE_OF_NAME_FOR_BUY = "init";

	NameForBuyValidator nameForBuyValidator = new NameForBuyValidator();

	public String receive() {
		String name = INIT_VALUE_OF_NAME_FOR_BUY;

		boolean rewindSwitch = true;
		while (rewindSwitch) {
			name = Console.readLine();

			rewindSwitch = nameForBuyValidator.validate(name);
		}

		return name;
	}
}
