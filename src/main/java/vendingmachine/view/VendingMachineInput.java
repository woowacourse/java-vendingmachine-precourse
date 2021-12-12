package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class VendingMachineInput {

	public int inputAmountOfMoney() {
		final String inputtedData = Console.readLine();
		return Integer.parseInt(inputtedData);
	}
}
