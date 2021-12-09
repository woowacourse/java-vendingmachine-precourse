package vendingmachine.view;

public class InputView {
	private static final String INITIAL_MONEY_SETTING = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String INITIAL_PRODUCT_SETTING = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String INSERT_MONEY = "투입 금액을 입력해 주세요.";
	private static final String PRODUCT_FOR_BUYING = "구매할 상품명을 입력해 주세요.";

	private static void printLineBreak() {
		System.out.println();
	}

	public static void printInitialMoneySettingMessage() {
		System.out.println(INITIAL_MONEY_SETTING);
	}

	public static void printInitialProductSettingMessage() {
		System.out.println(INITIAL_PRODUCT_SETTING);
	}

	public static void printInsertMoneyMessage() {
		printLineBreak();
		System.out.println(INSERT_MONEY);
	}

	public static void printProductForBuyingMessage() {
		System.out.println(PRODUCT_FOR_BUYING);
	}
}
