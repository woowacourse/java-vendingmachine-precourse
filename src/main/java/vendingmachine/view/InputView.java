package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.Message;

public class InputView {

	public static void printMessageToGetAmountMoneyOfVendingMachine() {
		System.out.println(Message.GET_AMOUNT_HOLDING_BY_VENDING_MACHINE.getText());
	}

	public static int inputTotalAmountMoneyOfVendingMachine() {
		return Integer.parseInt(Console.readLine());
	}
}
