package vendingmachine.view;

public class ExceptionView {
	private static final String ERROR_MESSAGE = "[ERROR] ";

	public static void errorUI(String message) {
		System.out.println(ERROR_MESSAGE + message);
	}
}
