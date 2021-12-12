package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;

import vendingmachine.util.Validator;

public class InputView {

	static Validator validator = new Validator();

	public static String readLineString() {
		return readLine();
	}

	public static int readPositiveInt() {
		try {
			OutputView.setVendingMachineMoney();
			String input = readLine();
			validator.validatePrice(input);
			return Integer.parseInt(input);
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			return readPositiveInt();
		}
	}
}
