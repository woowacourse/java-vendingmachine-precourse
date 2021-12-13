package vendingmachine.service;

import static vendingmachine.service.exception.InputExceptionService.*;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.UserAccount;
import vendingmachine.view.exception.ErrorMessage;

public class UserAccountService {

	public static void setUserAccount() {
		while (true) {
			String input = Console.readLine();
			if (isValid(input)) {
				break;
			}
		}
	}

	private static boolean isValid(String input) {
		try {
			checkEmptyString(input);
			int userAccount = parseToInt(input);
			checkModTen(userAccount);
			checkZeroOrPositiveInt(userAccount);
			UserAccount.setUserAccount(userAccount);
			return true;
		} catch (IllegalArgumentException e) {
			ErrorMessage.print(e.getMessage());
			return false;
		}
	}
}
