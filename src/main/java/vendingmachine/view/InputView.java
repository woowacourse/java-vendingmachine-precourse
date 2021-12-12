package vendingmachine.view;

import static vendingmachine.utils.Formatter.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String NOTICE_INPUT_INITIAL_LEFT_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String NOTICE_INPUT_MENU_INFOS = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String NOTICE_INPUT_MONEY = "투입 금액을 입력해 주세요.";
	private static final String NOTICE_INPUT_MENU_TO_BUY = "구매할 상품명을 입력해 주세요.";
	private static final String NOTICE_LEFT_INPUT_MONEY = "투입 금액: ";

	public static String getInitialLeftMoney() {
		System.out.println(NOTICE_INPUT_INITIAL_LEFT_MONEY);
		return Console.readLine();
	}

	public static String getMenuInfo() {
		System.out.println(NOTICE_INPUT_MENU_INFOS);
		return Console.readLine();
	}

	public static String getMoney() {
		System.out.println();
		System.out.println(NOTICE_INPUT_MONEY);
		return Console.readLine();
	}

	public static String getMenuToBuy() {
		System.out.println(NOTICE_INPUT_MENU_TO_BUY);
		return Console.readLine();
	}

	public static void showLeftMoney(int leftMoney) {
		System.out.println();
		System.out.println(NOTICE_LEFT_INPUT_MONEY + formatToKoreanCurrencyUnit(leftMoney));
	}
}
