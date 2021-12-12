package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.utils.Constant;

public class OutputView {

	public static final String PRINT_HOLDING_COIN = "자판기가 보유한 동전";

	public static void printHoldingCoin(Map<Coin, Integer> holdingCoin) {
		System.out.println(PRINT_HOLDING_COIN);
		holdingCoin.entrySet()
			.stream()
			.map(e -> String.join("\n", e.getKey().getAmount() + "원 - " + e.getValue() + "개"))
			.forEach(System.out::println);
		System.out.println();
	}

	public static void printEnteredAmount(int enteredAmount) {
		System.out.println(Constant.PRINT_ENTERED_AMOUNT + enteredAmount + Constant.WON);
	}

	public static void printReturnCoin(Map<Coin, Integer> returnCoin) {
		System.out.println(Constant.RETURN_COIN);
		if (returnCoin.isEmpty()) {
			System.out.println(Constant.RETURN_COIN_NONE);
		} else {
			returnCoin.entrySet()
				.stream()
				.map(e -> String.join("\n", e.getKey().getAmount() + "원 - " + e.getValue() + "개"))
				.forEach(System.out::println);
		}
	}
}
