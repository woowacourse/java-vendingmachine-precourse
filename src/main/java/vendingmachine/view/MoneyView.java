package vendingmachine.view;

import static vendingmachine.Constants.*;

public class MoneyView {
	public static void messageInputMoney() {
		System.out.println(MESSAGE_INPUT_MONEY);
	}

	public static void messageInputUserMoney() {
		System.out.println(MESSAGE_INPUT_USER_MONEY);
	}

	public static void printLastUserMoney(long money) {
		System.out.println(MESSAGE_USER_MONEY + money + STRING_WON);
	}
}
