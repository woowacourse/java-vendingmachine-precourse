package vendingmachine.view;

import static constant.StringConstant.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String getVendingMachineBalance() {
		System.out.println(INPUT_VENDING_MACHINE_BALANCE);
		String balance = Console.readLine();
		return balance;
	}

	public static String getVendingMachineProducts() {
		System.out.println(INPUT_VENDING_MACHINE_PRODUCT);
		String products = Console.readLine();
		return products;
	}

	public static void getOrderedProduct() {
	}
}
