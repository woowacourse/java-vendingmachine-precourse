package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Coin;

public class OutputView {

	public static final String PRINT_HOLDING_COIN = "자판기가 보유한 동전";
	public static final String PRINT_NEW_LINE = "\n";
	public static final String PRINT_WON = "원";
	public static final String PRINT_MID = "-";
	public static final String PRINT_COIN_NUM = "개";
	public static final String PRINT_ENTERED_AMOUNT = "투입 금액: ";
	public static final String PRINT_RETURN_COIN = "잔돈";
	public static final String PRINT_RETURN_COIN_NONE = "잔돈이 없습니다.";

	public static void printHoldingCoin(Map<Coin, Integer> holdingCoin) {
		System.out.println(PRINT_HOLDING_COIN);
		holdingCoin.entrySet()
			.stream()
			.map(e -> String.join(PRINT_NEW_LINE,
				e.getKey()
					.getAmount() + PRINT_WON + " " + PRINT_MID + " " + e.getValue() + PRINT_COIN_NUM))
			.forEach(System.out::println);
		System.out.println();
	}

	public static void printEnteredAmount(int enteredAmount) {
		System.out.println(PRINT_ENTERED_AMOUNT + enteredAmount + PRINT_WON);
	}

	public static void printReturnCoin(Map<Coin, Integer> returnCoin) {
		System.out.println(PRINT_RETURN_COIN);
		returnCoin.entrySet()
			.stream()
			.map(e -> String.join("\n", e.getKey().getAmount() + "원 - " + e.getValue() + "개"))
			.forEach(System.out::println);
		if (returnCoin.isEmpty()) {
			System.out.println(PRINT_RETURN_COIN_NONE);
		}
	}
}
