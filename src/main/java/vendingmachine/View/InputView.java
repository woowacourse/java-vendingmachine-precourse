package vendingmachine.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static final String PRINT_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String PRINT_BEVERAGE_GROUP = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String PRINT_USER_MONEY = "투입 금액을 입력해 주세요.";
	public static final String PRINT_BUY_BEVERAGE = "구매할 상품명을 입력해 주세요.";

	public static String machineMoneyInput() {
		System.out.println(PRINT_MACHINE_MONEY);
		return Console.readLine();
	}

	public static String beverageGroupInput() {
		System.out.println(PRINT_BEVERAGE_GROUP);
		return Console.readLine();
	}

	public static String userMoneyInput() {
		System.out.println(PRINT_USER_MONEY);
		return Console.readLine();
	}

	public static String beverageNameInput() {
		System.out.println(PRINT_BUY_BEVERAGE);
		return Console.readLine();
	}
}
