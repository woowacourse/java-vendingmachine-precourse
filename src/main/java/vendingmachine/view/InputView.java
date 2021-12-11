package vendingmachine.view;

import static constant.StringConstant.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String getVendingMachineBalance() {
		System.out.println(INPUT_VENDING_MACHINE_BALANCE);
		return Console.readLine();
	}

	public static String getVendingMachineProducts() {
		System.out.println(INPUT_VENDING_MACHINE_PRODUCT);
		return Console.readLine();
	}

	public static String getInsertPrice() {
		System.out.println(INSERT_PRICE_MESSAGE);
		return Console.readLine();
	}

	public static void getOrderedProduct() {
	}
}
