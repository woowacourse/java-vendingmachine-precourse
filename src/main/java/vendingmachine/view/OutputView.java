package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Coins;

public class OutputView {
	public static final String HOLDING_COIN_AMOUNT_TEXT = "%s원 - %s개%n";

	public static void printError(String error) {
		System.out.println(error);
	}

	public static void printHoldingCashRequest() {
		System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
	}

	public static void printNewLine() {
		System.out.println();
	}

	public static void printHoldingCoinStatus(Coins coins) {
		printNewLine();
		System.out.println("자판기가 보유한 동전");
		for (Map.Entry<Integer, Integer> coin : coins.findAll().entrySet()) {
			System.out.printf(HOLDING_COIN_AMOUNT_TEXT, coin.getKey(), coin.getValue());
		}
	}

	public static void printItemsRequest() {
		System.out.println("상품명과 가격, 수량을 입력해 주세요.");
	}

	public static void printInsertingMoneyRequest() {
		printNewLine();
		System.out.println("투입 금액을 입력해 주세요.");
	}

	public static void printItemPerChaseRequest() {
		System.out.println("구매할 상품명을 입력해 주세요.");
	}

	public static void printChanges(Coins coins) {
		printNewLine();
		System.out.println("잔돈");
		for (Map.Entry<Integer, Integer> coin : coins.findAll().entrySet()) {
			if (coin.getValue() <= 0) {
				continue;
			}
			System.out.printf(HOLDING_COIN_AMOUNT_TEXT, coin.getKey(), coin.getValue());
		}
	}
}
