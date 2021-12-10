package vendingmachine;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {
	private static final String GET_REMAINS = "\n자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String GET_ITEM_STATUS = "\n상품명과 가격, 수량을 입력해 주세요.";
	private static final String GET_USER_MONEY = "\n투입 금액을 입력해 주세요.";
	private static final String GET_ITEM_TO_BUY = "구매할 상품명을 입력해 주세요.";

	public static int GetRemains() {
		int remains;
		do {
			System.out.println(GET_REMAINS);
			remains = Integer.parseInt(readLine());
		} while (!UserMoney.valid(remains));
		return remains;
	}

	public static void printGetItemStatus() {
		System.out.println(GET_ITEM_STATUS);
	}

	public static int GetUserMoney() {
		int userMoney;
		do {
			System.out.println(GET_USER_MONEY);
			userMoney = Integer.parseInt(readLine());
		} while (!UserMoney.valid(userMoney));
		return userMoney;
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
