package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class InputReceiver {
	public static int getNumber(){
		String number;

		//VendingMachinePrinter.printGetHoldingAmountMessage();

		while (true) {
			try {
				number = Console.readLine();
				InputValidator.validateNumber(number);
				return Integer.parseInt(number);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				//VendingMachinePrinter.printGetHoldingAmountMessage();
			}
		}
	}
}
