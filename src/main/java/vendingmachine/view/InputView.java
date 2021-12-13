package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validator.InputValidator;

public class InputView {

	public static final String INPUT_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public static int getMachineMoney() {
		while (true) {
			try {
				System.out.println(INPUT_MACHINE_MONEY);
				String input = Console.readLine();
				InputValidator.validateMachineMoney(input);
				return Integer.parseInt(input);
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
	}
}
