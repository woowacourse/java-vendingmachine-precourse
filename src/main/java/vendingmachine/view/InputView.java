package vendingmachine.view;

import static constants.VendingMachineConstants.*;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validator.NumberValidator;

public class InputView {
	public static int getVendingMachineMoney() {
		while (true) {
			System.out.println(VENDING_MACHINE_MONEY_INPUT_MESSAGE);
			String inputMachineMoney = Console.readLine();
			try {
				NumberValidator.checkNumber(inputMachineMoney);
				return Integer.parseInt(inputMachineMoney);
			} catch (IllegalArgumentException e) {
				OutputView.printError(e.getMessage());
			}
		}
	}
}
