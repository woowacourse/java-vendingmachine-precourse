package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputUtil {
	private static final String NOT_INT_ERROR = "정수가 아닙니다.";

	private InputUtil() {
	}

	public static int readInt() {
		try {
			return Integer.parseInt(readLine());
		} catch (NumberFormatException e) {
			OutputView.printErrorMessage(NOT_INT_ERROR);
			return readInt();
		}
	}
}
