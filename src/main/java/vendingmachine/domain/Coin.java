package vendingmachine.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.view.ErrorMessage;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	public static final int INITIAL_BALANCE_VALUE = 0;
	public static final int BALANCE_THRESHOLD = 0;
	public static final int INCREASE_COUNT = 1;
	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static Map<Coin, Integer> decideCoinRandomly(int balance, Map<Coin, Integer> balanceMap) {
		initializeValue(balanceMap);
		while (needMoreCalculation(balance)) {
			int amount = Randoms.pickNumberInList(
				Arrays.stream(values())
					.map(Coin::getAmount)
					.collect(Collectors.toList())
			);
			if (amount <= balance) {
				balanceMap.put(getCoin(amount), getPreviousCount(balanceMap, amount) + INCREASE_COUNT);
				balance -= amount;
			}
		}
		return balanceMap;
	}

	private static void initializeValue(Map<Coin, Integer> balanceMap) {
		for (Coin coin : values()) {
			balanceMap.put(coin, INITIAL_BALANCE_VALUE);
		}
	}

	private static boolean needMoreCalculation(int balance) {
		return balance > BALANCE_THRESHOLD;
	}

	public int getAmount() {
		return amount;
	}

	public static Coin getCoin(int amount) {
		return Arrays.stream(values())
			.filter(coin -> coin.getAmount() == amount)
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_COIN_AMOUNT));
	}

	private static int getPreviousCount(Map<Coin, Integer> balanceMap, int amount) {
		return balanceMap.get(getCoin(amount));
	}
}
