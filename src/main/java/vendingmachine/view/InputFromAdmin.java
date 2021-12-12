package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utill.InputValidator;

public class InputFromAdmin {
	private static final String INPUT_MACHINE_MONEY_MSG = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	private InputValidator inputValidator = new InputValidator();

	public int inputMachineMoney() {
		System.out.println(INPUT_MACHINE_MONEY_MSG);
		String inputAmount = Console.readLine();

		int amount = inputValidator.validMachineMoney(inputAmount);

		if (amount >= 0) {
			return amount;
		}
		return inputMachineMoney();
	}
}
