package vendingmachine.view;

public class OutputView {

	public static final String MONETARY_UNIT = "원";
	private static final String ERROR_FORM = "[ERROR] : ";
	private static final String REMAINING_DEPOSIT_MESSAGE = "투입 금액: ";

	public static void printError(Exception exception) {
		System.out.println(ERROR_FORM + exception.getMessage() + "\n");
	}

	public static void printRemainingDeposit(int deposit) {
		System.out.println("\n" + REMAINING_DEPOSIT_MESSAGE + deposit + MONETARY_UNIT);
	}

}
