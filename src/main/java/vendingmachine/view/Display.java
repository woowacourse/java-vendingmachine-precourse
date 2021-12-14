package vendingmachine.view;

import vendingmachine.model.cash.domain.Coin;
import vendingmachine.model.cash.service.Cashier;

/**
 * 자판기의 출력창 역할을 하는 view class
 *
 * @author YJGwon
 * @version 1.0
 * @since 1.0
 */
public class Display {
	private static final String HOLDING_AMOUNT_QUESTION = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String ITEM_QUESTION = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String INSERT_AMOUNT_QUESTION = "투입 금액을 입력해 주세요.";
	private static final String WHAT_TO_BUY_QUESTION = "구매할 상품명을 입력해 주세요.";

	private static final String ALL_COIN_TITLE = "자판기가 보유한 동전";
	private static final String CHANGES_TITLE = "잔돈";

	private static final String ERROR_FORMAT = "[ERROR] %s%n";

	public void askHoldingAmount() {
		System.out.println(HOLDING_AMOUNT_QUESTION);
	}

	public void askItems() {
		System.out.println(ITEM_QUESTION);
	}

	public void askInsertAmount() {
		System.out.println(INSERT_AMOUNT_QUESTION);
	}

	public void askWhatToBuy() {
		System.out.println(WHAT_TO_BUY_QUESTION);
	}

	public void printAllCoin() {
		System.out.println(ALL_COIN_TITLE);
		for (Coin coin : Coin.values()) {
			System.out.println(coin.toString());
		}
	}

	public void printInsertAmount(Cashier cashier) {
		System.out.println(cashier.toString());
	}

	public void printChanges() {
		System.out.println(CHANGES_TITLE);
		for (Coin coin : Coin.values()) {
			if (!coin.isChangeCount(0)) {
				System.out.println(coin.changeToString());
			}
		}
	}

	public void printBlankLine() {
		System.out.println();
	}

	public void printError(Exception exception) {
		System.out.printf(ERROR_FORMAT, exception.getMessage());
	}
}
