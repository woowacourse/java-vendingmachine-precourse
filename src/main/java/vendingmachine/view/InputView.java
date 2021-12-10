package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;

import vendingmachine.util.Validator;

public class InputView {

	static Validator validator = new Validator();

	public static String readLineString() {
		return readLine();
	}

	public static int readLineInt() {
		String input = readLine();
		validator.validateNumber(input);
		return Integer.parseInt(input);
	}
}
