package vendingmachine.view;

public class OutputView {
	private static final String ERROR = "[ERROR] ";
	private static final String LINE_SEPARATOR = System.lineSeparator();

	public static void printLineSeparator() {
		System.out.print(System.lineSeparator());
	}

	public static void printErrorMessage(Exception e) {
		System.out.println(ERROR + e.getMessage() + LINE_SEPARATOR);
	}
}
