package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;

public class Output {
	static final String MSG_PRINT_COINS_IN_MACHINE = "\n자판기가 보유한 동전";
	static final String MSG_INPUT_MONEY = "\n투입 금액: ";
	static final String MONETARY_UNIT = "원";
	static final String CHANGE = "잔돈";
	static final String HYPHEN = " - ";
	static final String COUNTING_UNIT = "개";

	public static void coinsInMachine(Coins coins) {
		System.out.println(MSG_PRINT_COINS_IN_MACHINE);
		System.out.println(coins);
	}

	public static void inputMoney(int inputMoney) {
		System.out.println(MSG_INPUT_MONEY + inputMoney + MONETARY_UNIT);
	}

	public static void change(Map<Coin, Integer> change) {
		System.out.println(CHANGE);
		change.entrySet()
			.stream()
			.filter((entry) -> entry.getValue() > 0)
			.forEach((entry) -> System.out.println(
				entry.getKey() + HYPHEN + entry.getValue() + COUNTING_UNIT));
	}
}
