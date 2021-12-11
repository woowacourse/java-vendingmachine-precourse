package vendingmachine.view;

import static constant.StringConstant.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String getVendingMachineBalance() {
		System.out.println(VENDING_MACHINE_BALANCE_MESSAGE);
		return Console.readLine();
	}

	public static String getVendingMachineProducts() {
		System.out.println(VENDING_MACHINE_PRODUCT_MESSAGE);
		return Console.readLine();
	}

	public static String getMoney() {
		System.out.println(INSERT_MONEY_MESSAGE);
		return Console.readLine();
	}

	public static String getOrderedProduct() {
		System.out.println(ORDER_PRODUCT_MESSAGE);
		return Console.readLine();
	}
}
