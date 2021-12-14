package view;

public class InputDisplay {
	private static final String ASK_INPUT_CHANGE_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String ASK_INPUT_PRODUCTS_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String ASK_INPUT_INSERTED_MONEY_MESSAGE = "투입 금액을 입력해 주세요.";
	private static final String ASK_INPUT_PRODUCT_TO_BUY_MESSAGE = "구매할 상품명을 입력해 주세요.";

	private InputDisplay() {
	}

	public static void askInputChange() {
		System.out.println(ASK_INPUT_CHANGE_MESSAGE);
	}

	public static void askInputProducts() {
		System.out.println();
		System.out.println(ASK_INPUT_PRODUCTS_MESSAGE);
	}

	public static void askInputInsertedMoney() {
		System.out.println();
		System.out.println(ASK_INPUT_INSERTED_MONEY_MESSAGE);
	}

	public static void askInputProductNameToBuy() {
		System.out.println(ASK_INPUT_PRODUCT_TO_BUY_MESSAGE);
	}
}
