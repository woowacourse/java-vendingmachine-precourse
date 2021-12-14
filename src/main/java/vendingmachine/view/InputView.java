package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;

import vendingmachine.model.UserMoney;

public class InputView {

	public static int GetRemains() {
		return getUserInput(Messages.GET_REMAINS);
	}

	public static void printGetItemStatus() {
		System.out.println(Messages.GET_ITEM_STATUS);
	}

	public static int GetUserMoney() {
		return getUserInput(Messages.GET_USER_MONEY);
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
				System.out.println(Messages.ERROR_NOT_NUMBER);
			} catch (IllegalArgumentException e) {
			}
		}
	}

	public static String GetItemToBuy(UserMoney userMoney) {
		System.out.println("\n투입 금액: " + userMoney.getMoney() + "원");
		System.out.println(Messages.GET_ITEM_TO_BUY);
		return readLine();
	}

	public static String getItemStatuses() {
		return readLine();
	}
}
