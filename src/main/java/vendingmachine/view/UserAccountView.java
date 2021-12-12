package vendingmachine.view;

import vendingmachine.domain.UserAccount;

public class UserAccountView {
	private static final String INPUT_GUIDE_MESSAGE = "투입 금액을 입력해주세요.";
	private static final String USER_ACCOUNT_FORMAT = "투입금액: %d";

	public static void printInputGuide() {
		System.out.println(INPUT_GUIDE_MESSAGE);
	}

	public static void printUserAccount() {
		int userAccount = UserAccount.getAccount();
		System.out.println(String.format(USER_ACCOUNT_FORMAT, userAccount));
	}
}
