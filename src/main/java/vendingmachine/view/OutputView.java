package vendingmachine.view;

public class OutputView {
	static final String HOLDING_MONEY_REQUEST_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	static final String HOLDING_COIN_MESSAGE = "자판기가 보유한 동전";
	static final String PRODUCT_INPUT_REQUEST_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
	static final String INPUT_MONEY_INPUT_REQUEST_MESSAGE = "투입 금액을 입력해 주세요.";
	static final String PRODUCT_TO_BUY_INPUT_REQUEST_MESSAGE = "구매할 상품명을 입력해 주세요.";

	public static void printHoldingMoneyRequestMessage() {
		System.out.println(HOLDING_MONEY_REQUEST_MESSAGE);
	}

	public static void printHoldingCoinMessage() {
		printEmptyLine();
		System.out.println(HOLDING_COIN_MESSAGE);
	}

	public static void printCoinInfo(String coin, int numberOfCoin) {
		System.out.println(coin + " - " + numberOfCoin + "개");
	}

	public static void printProductInputRequestMessage() {
		printEmptyLine();
		System.out.println(PRODUCT_INPUT_REQUEST_MESSAGE);
	}

	public static void printInputMoneyRequestMessage() {
		printEmptyLine();
		System.out.println(INPUT_MONEY_INPUT_REQUEST_MESSAGE);
	}

	public static void printProductNameToBuyRequestMessage() {
		System.out.println(PRODUCT_TO_BUY_INPUT_REQUEST_MESSAGE);
	}

	public static void printCustomerChanges(int changes) {
		printEmptyLine();
		System.out.println("투입 금액: " + changes + "원");
	}

	public static void printEmptyLine() {
		System.out.println();
	}
}
