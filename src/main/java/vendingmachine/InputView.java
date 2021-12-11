package vendingmachine;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {
	private static final String GET_REMAINS = "\n자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String GET_ITEM_STATUS = "\n상품명과 가격, 수량을 입력해 주세요.";
	private static final String GET_USER_MONEY = "\n투입 금액을 입력해 주세요.";
	private static final String GET_ITEM_TO_BUY = "구매할 상품명을 입력해 주세요.";
	private static final String ERROR_NOT_NUMBER = "[ERROR] 금액은 숫자여야 합니다.";

	public static int GetRemains() {
		return getUserInput(GET_REMAINS);
	}

	public static void printGetItemStatus() {
		System.out.println(GET_ITEM_STATUS);
	}

	public static int GetUserMoney() {
		return getUserInput(GET_USER_MONEY);
	}

	private static int getUserInput(String getUserInput) {
		int UserInput;
		while (true) {
			try {
				System.out.println(getUserInput);
				String userInput = readLine();
				UserInput = Integer.parseInt(userInput);
				UserMoney.valid(UserInput);
				return UserInput;
			} catch (NumberFormatException e) {
				System.out.println(ERROR_NOT_NUMBER);
			} catch (IllegalArgumentException e) {
			}
		}
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
