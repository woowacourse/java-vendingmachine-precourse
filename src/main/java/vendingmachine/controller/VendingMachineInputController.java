package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.service.VendingMachineInputService;
import vendingmachine.view.VendingMachineAccountInputView;

public class VendingMachineInputController {
	public static final int INVALID_INPUT = -1;

	public static int getAccountInput() {
		VendingMachineAccountInputView.print();

		int machineAccount = INVALID_INPUT;
		while (machineAccount == INVALID_INPUT) {
			String input = Console.readLine();
			machineAccount = VendingMachineInputService.validateInput(input);
		}
		return machineAccount;
	}

}
