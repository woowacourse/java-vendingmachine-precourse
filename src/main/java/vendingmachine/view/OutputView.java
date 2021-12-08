package vendingmachine.view;

public class OutputView {

	private static final String ERROR_FORM = "[ERROR] : ";
	private static final String INPUT_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String INPUT_PRODUCT_INFO_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String ASK_DEPOSIT_AMOUNT_MESSAGE = "투입 금액을 입력해 주세요.";

	public static void printError(Exception exception) {
		System.out.println(ERROR_FORM + exception.getMessage());
	}

	public void askInputMoneyOfVendingMachine() {
		System.out.println(INPUT_MONEY_MESSAGE);
	}

	public void askProductInfo() {
		System.out.println(INPUT_PRODUCT_INFO_MESSAGE);
	}

	public void askDepositAmount() {
		System.out.println(ASK_DEPOSIT_AMOUNT_MESSAGE);
	}

}
