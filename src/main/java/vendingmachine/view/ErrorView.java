package vendingmachine.view;

public class ErrorView {
	private static final String ERROR_PREFIX = "[ERROR] ";

	public static void showMessage(IllegalArgumentException illegalArgumentException) {
		System.out.println(ERROR_PREFIX + illegalArgumentException.getMessage());
	}
}
