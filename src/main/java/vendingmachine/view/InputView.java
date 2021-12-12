package vendingmachine.view;

import static constant.CharacterConstant.*;
import static constant.StringConstant.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String getVendingMachineBalance() {
		System.out.println(VENDING_MACHINE_BALANCE_MESSAGE);
		return Console.readLine();
	}

	public static String getVendingMachineProducts() {
		System.out.println(LINE_STAMP + VENDING_MACHINE_PRODUCT_MESSAGE);
		return Console.readLine();
	}

	public static String getMoney() {
		System.out.println(LINE_STAMP + INSERT_MONEY_MESSAGE);
		return Console.readLine();
	}

	public static String getOrderedProduct() {
		System.out.println(ORDER_PRODUCT_MESSAGE);
		return Console.readLine();
	}
}
