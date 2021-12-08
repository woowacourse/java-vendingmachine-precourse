package vendingmachine.view;

import static constant.StringConstant.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String getVendingMachineBalance() {
		System.out.println(INPUT_VENDING_MACHINE_BALANCE);
		String balance = Console.readLine();
		return balance;
	}

	public static void getVendingMachineProducts() {
	}

	public static void getOrderedProduct() {
	}
}
