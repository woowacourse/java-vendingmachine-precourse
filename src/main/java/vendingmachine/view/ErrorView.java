package vendingmachine.view;

import static vendingmachine.constant.ErrorMessage.*;

public class ErrorView {

	public static void illegalArgumentException(String msg) {
		System.out.println(ERROR_PREFIX + msg);
	}
}
