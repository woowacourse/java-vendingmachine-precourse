package vendingmachine;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {
	private static final String GET_REMAINS = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String GET_ITEM_STATUS = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String GET_USER_MONEY = "투입 금액을 입력해 주세요.";
	private static final String GET_ITEM_TO_BUY = "구매할 상품명을 입력해 주세요.";

	public static void printGetRemains() {
		System.out.println(GET_REMAINS);
	}

	public static void printGetItemStatus() {
		System.out.println(GET_ITEM_STATUS);
	}

	public static void printGetUserMoney() {
		System.out.println(GET_USER_MONEY);
	}

	public static void printGetItemToBuy(UserMoney userMoney) {
		System.out.println("투입 금액: " + userMoney.getMoney() + "원");
		System.out.println(GET_ITEM_TO_BUY);
	}

	public static String getItemStatuses() {
		return readLine();
	}
}
