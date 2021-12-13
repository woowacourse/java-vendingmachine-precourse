package vendingmachine.view;

import vendingmachine.model.Coins;

public class OutputView {
	private static final String INPUT_HOLDING_AMOUNT = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String INPUT_PRODUCT = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String OUTPUT_HOLDING_COINS = "자판기가 보유한 동전";
	private static final String INPUT_INSERT_MONEY = "투입 금액을 입력해 주세요.";
	private static final String INPUT_PURCHASE_PRODUCT = "구매할 상품명을 입력해 주세요.";

	private OutputView() {
	}

	public static void printInputHoldingAmountMessage() {
		System.out.println(INPUT_HOLDING_AMOUNT);
	}

	public static void printInputProductMessage() {
		System.out.println(INPUT_PRODUCT);
	}

	public static void printCoins(Coins coins) {
		System.out.println(OUTPUT_HOLDING_COINS);
		System.out.println(coins.toString());
	}

	public static void printExceptionMessage(String message) {
		System.out.println(message);
	}

	public static void printInputInsertMoneyMessage() {
		System.out.println(INPUT_INSERT_MONEY);
	}

	public static void printInputPurchaseProductMessage() {
		System.out.println(INPUT_PURCHASE_PRODUCT);
	}

	public static void printInsertMoney(int insertMoney) {
		System.out.println(insertMoney);
	}
}
