package vendingmachine.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static final String PRINT_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String PRINT_MACHINE_PRODUCTS = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String PRINT_USER_MONEY = "투입 금액을 입력해 주세요.";
	public static final String PRINT_BUY_PRODUCT = "구매할 상품명을 입력해 주세요.";

	public static String machineMoneyInput() {
		System.out.println(PRINT_MACHINE_MONEY);
		return Console.readLine();
	}

	public static String machineProductInput() {
		System.out.println(PRINT_MACHINE_PRODUCTS);
		return Console.readLine();
	}

	public static String userMoneyInput() {
		System.out.println(PRINT_USER_MONEY);
		return Console.readLine();
	}

	public static String buyProductNameInput() {
		System.out.println(PRINT_BUY_PRODUCT);
		return Console.readLine();
	}
}
