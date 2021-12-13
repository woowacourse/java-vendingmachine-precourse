package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Money;

public class OutputView {
	private static final int ZERO = 0;
	private static final String WON = "원";
	private static final String COUNT_UNIT = "개";
	private static final String HYPHEN = "-";
	private static final String CHANGES = "잔돈";
	private static final String WHITE_SPACE = " ";
	private static final String OUTPUT_TYPE_STRING = "%s";
	public static final String HOLDING_COIN_AMOUNT_TEXT = OUTPUT_TYPE_STRING + WON + WHITE_SPACE + HYPHEN + WHITE_SPACE
		+ OUTPUT_TYPE_STRING + COUNT_UNIT;
	private static final String HOLDING_CASH_REQUEST_TEXT = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String HOLDING_COIN_TEXT = "자판기가 보유한 동전";
	private static final String REGISTER_ITEM_REQUEST_TEXT = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String INSERTING_MONEY_REQUEST_TEXT = "투입 금액을 입력해 주세요.";
	private static final String PERCHASE_ITEM_REQUEST_TEXT = "구매할 상품명을 입력해 주세요.";


	public static void printError(String error) {
		System.out.println(error);
	}

	public static void printHoldingCashRequest() {
		System.out.println(HOLDING_CASH_REQUEST_TEXT);
	}

	public static void printNewLine() {
		System.out.println();
	}

	public static void printHoldingCoinStatus(Coins coins) {
		printNewLine();
		System.out.println(HOLDING_COIN_TEXT);
		for (Map.Entry<Integer, Integer> coin : coins.findAll().entrySet()) {
			System.out.printf(HOLDING_COIN_AMOUNT_TEXT, coin.getKey(), coin.getValue());
			printNewLine();
		}
	}

	public static void printChanges(Map<Integer, Integer> changes) {
		if (changes.size() <= ZERO) {
			return;
		}
		printNewLine();
		System.out.println(CHANGES);
		for (Map.Entry<Integer, Integer> coin : changes.entrySet()) {
			System.out.printf(HOLDING_COIN_AMOUNT_TEXT, coin.getKey(), coin.getValue());
			printNewLine();
		}
	}

	public static void printItemsRequest() {
		printNewLine();
		System.out.println(REGISTER_ITEM_REQUEST_TEXT);
	}

	public static void printInsertingMoneyRequest() {
		printNewLine();
		System.out.println(INSERTING_MONEY_REQUEST_TEXT);
	}

	public static void printItemPerChaseRequest() {
		System.out.println(PERCHASE_ITEM_REQUEST_TEXT);
	}

	public static void printMoney(Money money) {
		printNewLine();
		System.out.println(money);
	}

}
