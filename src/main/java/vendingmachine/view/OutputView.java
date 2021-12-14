package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Coin;

public class OutputView {
	private static final int ZERO = 0;
	private static final String CHANGES = "잔돈";
	public static final String HOLDING_COIN_NUMBER_TEXT = "%s원 - %s개";
	private static final String HOLDING_AMOUNT_REQUEST_TEXT = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String HOLDING_COIN_TEXT = "자판기가 보유한 동전";
	private static final String INSERTED_AMOUNT_TEXT = "투입 금액: %d원";
	private static final String REGISTER_ITEM_REQUEST_TEXT = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String INSERT_MONEY_REQUEST_TEXT = "투입 금액을 입력해 주세요.";
	private static final String BUY_ITEM_REQUEST_TEXT = "구매할 상품명을 입력해 주세요.";

	public void printError(final String error) {
		System.out.println(error);
	}

	public void printHoldingAmountRequest() {
		System.out.println(HOLDING_AMOUNT_REQUEST_TEXT);
	}

	public void printNewLine() {
		System.out.println();
	}

	public void printHoldingCoins(final Map<Coin, Integer> coins) {
		printNewLine();
		System.out.println(HOLDING_COIN_TEXT);
		for (Map.Entry<Coin, Integer> coin : coins.entrySet()) {
			System.out.printf(HOLDING_COIN_NUMBER_TEXT, coin.getKey().getAmount(), coin.getValue());
			printNewLine();
		}
	}

	public void printChanges(final Map<Coin, Integer> changes) {
		if (changes.size() <= ZERO) {
			return;
		}
		printNewLine();
		System.out.println(CHANGES);
		for (Map.Entry<Coin, Integer> coin : changes.entrySet()) {
			System.out.printf(HOLDING_COIN_NUMBER_TEXT, coin.getKey().getAmount(), coin.getValue());
			printNewLine();
		}
	}

	public void printEnterItemListRequest() {
		printNewLine();
		System.out.println(REGISTER_ITEM_REQUEST_TEXT);
	}

	public void printInsertMoneyRequest() {
		printNewLine();
		System.out.println(INSERT_MONEY_REQUEST_TEXT);
	}

	public void printBuyItemRequest() {
		System.out.println(BUY_ITEM_REQUEST_TEXT);
	}

	public void printMoney(final int money) {
		printNewLine();
		System.out.printf(INSERTED_AMOUNT_TEXT, money);
		printNewLine();
	}

}
