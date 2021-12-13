package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.constant.ErrorMessage.*;
import static vendingmachine.constant.InputMessage.*;
import static vendingmachine.constant.SystemMessage.*;

public class InputView {
	public static int getVendingMachineAmount() {
		System.out.println(ASKING_VENDING_MACHINE_AMOUNT_MESSAGE);
		return getIntegerInput();
	}

	public static String getProducts() {
		System.out.println(ASKING_PRODUCT_INFORMATION);
		return readLine();
	}

	public static int getUserAmount() {
		System.out.println();
		System.out.println(ASKING_USER_AMOUNT);
		return getIntegerInput();
	}

	public static String getProductName() {
		System.out.println(ASKING_PRODUCT_NAME_TO_BUY);
		return readLine();
	}

	private static int getIntegerInput() {
		String integerInput = readLine();
		if (!integerInput.matches(INTEGER_INPUT_REGEX)) {
			throw new IllegalArgumentException(INPUT_IS_NOT_INTEGER_ERROR_MESSAGE);
		}
		return Integer.parseInt(integerInput);
	}
}
