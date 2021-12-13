package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validator.InputValidator;

public class InputView {
	public static void getMachineMoney() {
		while (true) {
			try {
				String input = Console.readLine();
				InputValidator.validateMachineMoney(input);
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
	}
}
