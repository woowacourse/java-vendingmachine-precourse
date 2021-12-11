package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constants.InputConstants;

public class InputManager {
	private final Validator validator;
	private final Converter converter;

	public InputManager() {
		this.validator = new Validator();
		this.converter = new Converter();
	}

	public int getStorageMoney() {
		int money = -1;
		while(true) {
			print(InputConstants.ASK_STORAGE_MONEY);
			String inputString = Console.readLine();
			money = validateAndReturnNumber(inputString);
			if(money != -1) {
				break;
			}
		}
		return money;
	}

	private int validateAndReturnNumber(String inputString) {
		if(checkErrorWithStorageMoneySize(inputString)) {
			return -1;
		}
		int money = converter.convertToInt(inputString);
		if(checkErrorWithStorageMoneyFormat(money)) {
			return -1;
		}
		return money;
	}

	private boolean checkErrorWithStorageMoneySize(String inputString) {
		try {
			validator.checkNumberString(inputString);
		}catch(IllegalArgumentException e) {
			print(getErrorMessage(InputConstants.ERROR_STORAGE_MONEY));
			return true;
		}
		return false;
	}

	private boolean checkErrorWithStorageMoneyFormat(int number) {
		try {
			validator.checkDivisionByTen(number);
		}catch (IllegalArgumentException e) {
			print(getErrorMessage(InputConstants.ERROR_STORAGE_MONEY_DIVISION));
			return true;
		}
		return false;
	}

	private void print(String message) {
		System.out.println(message);
	}

	private String getErrorMessage(String message) {
		return String.format(InputConstants.ERROR, message);
	}
}
