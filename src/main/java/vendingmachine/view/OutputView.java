package vendingmachine.view;

public class OutputView {
	static final String HOLDING_AMOUNT_REQUEST_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	static final String HOLDING_COIN_MESSAGE = "자판기가 보유한 동전";
	static final String PRODUCT_INPUT_REQUEST_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
	static final String INPUT_AMOUNT_INPUT_REQUEST_MESSAGE = "투입 금액을 입력해 주세요.";
	static final String PRODUCT_TO_BUY_INPUT_REQUEST_MESSAGE = "구매할 상품명을 입력해 주세요.";
	static final String CHANGES_MESSAGE = "잔돈";
	static final String ERROR = "[ERROR]";
	static final String SPACE = " ";

	public static void printHoldingAmountRequestMessage() {
		System.out.println(HOLDING_AMOUNT_REQUEST_MESSAGE);
	}

	public static void printHoldingCoinMessage() {
		printEmptyLine();
		System.out.println(HOLDING_COIN_MESSAGE);
	}

	public static void printCoinInfo(String coinInfo) {
		System.out.println(coinInfo);
	}

	public static void printProductInputRequestMessage() {
		printEmptyLine();
		System.out.println(PRODUCT_INPUT_REQUEST_MESSAGE);
	}

	public static void printInputAmountRequestMessage() {
		printEmptyLine();
		System.out.println(INPUT_AMOUNT_INPUT_REQUEST_MESSAGE);
	}

	public static void printProductNameToBuyRequestMessage() {
		System.out.println(PRODUCT_TO_BUY_INPUT_REQUEST_MESSAGE);
	}

	public static void printCustomerChanges(int changes) {
		printEmptyLine();
		System.out.println("투입 금액: " + changes + "원");
	}

	public static void printChangesMessage() {
		System.out.println(CHANGES_MESSAGE);
	}

	public static void printEmptyLine() {
		System.out.println();
	}

	public static void printErrorMessage(String message) {
		System.out.println(ERROR + SPACE + message);
	}
}
