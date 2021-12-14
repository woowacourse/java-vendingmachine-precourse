package vendingmachine.view;

import static java.lang.System.*;
import static vendingmachine.constant.SystemMessage.*;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.SystemMessage;
import vendingmachine.validator.InputValidator;

public class InputView {


	public static int getMachineMoney() {
		while (true) {
			try {
				out.println(INPUT_MACHINE_MONEY);
				String input = Console.readLine();
				InputValidator.validateMachineMoney(input);
				printEmptyLine();
				return Integer.parseInt(input);
			} catch (Exception exception) {
				out.println(exception.getMessage());
			}
		}
	}
}
