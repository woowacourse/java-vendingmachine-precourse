package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.service.VendingMachineAccountService;
import vendingmachine.view.VendingMachineAccountView;

public class VendingMachineAccountController {
	public static final int INVALID_INPUT = -1;

	public static int getAccountInput() {
		VendingMachineAccountView.printInputGuide();

		int machineAccount = INVALID_INPUT;
		while (machineAccount == INVALID_INPUT) {
			String input = Console.readLine();
			machineAccount = VendingMachineAccountService.validateInput(input);
		}
		return machineAccount;
	}

}
