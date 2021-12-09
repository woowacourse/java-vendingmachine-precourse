package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.VendingMachineAccount;
import vendingmachine.view.ErrorMessage;
import vendingmachine.view.VendingMachineAccountInputView;

public class VendingMachineInputController {
	private static final int INVALID_INPUT = -1;

	public static void setCoin() {
		VendingMachineAccountInputView.print();
		int machineAccount = INVALID_INPUT;
		while (machineAccount == INVALID_INPUT) {
			machineAccount = getValidInput();
		}
		VendingMachineAccount.setRandomCoins(machineAccount);
	}

	private static int getValidInput() {
		try {
			int input = ExceptionController.parseToInt(Console.readLine());
			ExceptionController.checkZeroOrPositiveInt(input);
			ExceptionController.checkModTen(input);
			return input;
		} catch (IllegalArgumentException e) {
			ErrorMessage.print(e.getMessage());
			return INVALID_INPUT;
		}

	}
}
