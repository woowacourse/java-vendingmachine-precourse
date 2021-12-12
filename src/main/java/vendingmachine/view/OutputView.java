package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.utils.Constant;

public class OutputView {

	public static void printHoldingCoin(Map<Coin, Integer> holdingCoin) {
		holdingCoin.entrySet()
			.stream()
			.map(e -> String.join("\n", e.getKey().getAmount() + "원 - " + e.getValue() + "개"))
			.forEach(System.out::println);
		System.out.println();
	}

	public static void printEnteredAmount(int enteredAmount) {
		System.out.println(Constant.PRINT_ENTERED_AMOUNT + enteredAmount + Constant.WON);
	}
}
