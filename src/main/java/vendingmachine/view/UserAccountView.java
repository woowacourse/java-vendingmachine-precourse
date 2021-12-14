package vendingmachine.view;

import vendingmachine.repository.UserAccount;

public class UserAccountView {
	private static final String INPUT_GUIDE_MESSAGE = "투입 금액을 입력해주세요.";
	private static final String USER_ACCOUNT_FORMAT = "투입 금액: %d원";

	public static void printInputGuide() {
		System.out.println(INPUT_GUIDE_MESSAGE);
	}

	public static void printUserAccount() {
		int userAccount = UserAccount.getAccount();
		System.out.println();
		System.out.printf((USER_ACCOUNT_FORMAT) + "%n", userAccount);
	}
}
