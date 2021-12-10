package vendingmachine.view;

public class OutputView {

	private static final String ERROR_FORM = "[ERROR] : ";
	private static final String INPUT_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String PRODUCT_REGISTRATION_REQUEST = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String ASK_DEPOSIT_AMOUNT_MESSAGE = "투입 금액을 입력해 주세요.";
	private static final String REMAINING_DEPOSIT_MESSAGE = "투입 금액: ";
	public static final String MONETARY_UNIT = "원";
	private static final String ASK_PRODUCT_WANT_TO_BUY = "구매할 상품명을 입력해 주세요.";

	public static void printError(Exception exception) {
		System.out.println(ERROR_FORM + exception.getMessage());
	}

	public void askInputMoneyOfVendingMachine() {
		System.out.println(INPUT_MONEY_MESSAGE);
	}

	public void askProductToRegister() {
		System.out.println(PRODUCT_REGISTRATION_REQUEST);
	}

	public void askDepositAmount() {
		System.out.println("\n" + ASK_DEPOSIT_AMOUNT_MESSAGE);
	}

	public void printRemainingDeposit(int deposit) {
		System.out.println("\n" + REMAINING_DEPOSIT_MESSAGE + deposit + MONETARY_UNIT);
	}

	public void askProductWantToBuy() {
		System.out.println(ASK_PRODUCT_WANT_TO_BUY);
	}

}
