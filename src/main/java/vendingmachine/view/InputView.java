package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String NOTICE_INPUT_INITIAL_LEFT_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public static String getNoticeInputInitialLeftMoney() {
		System.out.println(NOTICE_INPUT_INITIAL_LEFT_MONEY);
		return Console.readLine();
	}
}
