package vendingmachine;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {
	private static final String GET_REMAINS = "\n자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String GET_ITEM_STATUS = "\n상품명과 가격, 수량을 입력해 주세요.";
	private static final String GET_USER_MONEY = "\n투입 금액을 입력해 주세요.";
	private static final String GET_ITEM_TO_BUY = "구매할 상품명을 입력해 주세요.";

	public static int GetRemains() {
		System.out.println(GET_REMAINS);
		return Integer.parseInt(readLine());
	}

	public static void printGetItemStatus() {
		System.out.println(GET_ITEM_STATUS);
	}

	public static int GetUserMoney() {
		System.out.println(GET_USER_MONEY);
		return Integer.parseInt(readLine());
	}

	public static String GetItemToBuy(UserMoney userMoney) {
		System.out.println("\n투입 금액: " + userMoney.getMoney() + "원");
		System.out.println(GET_ITEM_TO_BUY);
		return readLine();
	}

	public static String getItemStatuses() {
		return readLine();
	}
}
