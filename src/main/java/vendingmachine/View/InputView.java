package vendingmachine.View;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Constants;

public class InputView {
	public static String machineMoneyInput() {
		System.out.println(Constants.PRINT_MACHINE_MONEY);
		return Console.readLine();
	}

	public static String machineProductInput() {
		System.out.println(Constants.PRINT_MACHINE_PRODUCTS);
		return Console.readLine();
	}

	public static String userMoneyInput() {
		System.out.println(Constants.PRINT_USER_MONEY);
		return Console.readLine();
	}

	public static String buyProductNameInput() {
		System.out.println(Constants.PRINT_BUY_PRODUCT);
		return Console.readLine();
	}
}
