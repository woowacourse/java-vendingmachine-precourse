package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.exception.NumberException.*;
import static vendingmachine.message.ViewMessage.*;

public class InputView {

	public static int requestPossessionMoney() {
		System.out.println(POSSESSION_MONEY_REQUEST_MESSAGE);
		return Integer.parseInt(inputMoney());
	}

	public static String inputMoney() {
		while (true) {
			String money = readLine();
			try {
				checkNumberException(money);
				return money;
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
	}
}
