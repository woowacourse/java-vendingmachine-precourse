package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.view.ErrorMessage;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static List<Integer> getPossibleQuantity(Integer amount, int balance) {
		List<Integer> list = new ArrayList<>();
		for (int quantity = 0; quantity <= getMaxQuantity(amount, balance); quantity++) {
			list.add(quantity);
		}
		return list;
	}

	public static int calculateResidue(Integer amount, int balance, int quantity) {
		return balance - amount * quantity;
	}

	public static int getMaxQuantity(Integer amount, int balance) {
		return balance / amount;
	}

	public static Map<Coin, Integer> decideCoinRandomly(int balance, Map<Coin, Integer> balanceMap) {
		initializeValue(balanceMap);
		while (balance > 0) {
			int pickCoin = Randoms.pickNumberInList(
				Arrays.stream(Coin.values())
					.map(Coin::getAmount)
						.collect(Collectors.toList())
					);
			if (pickCoin <= balance) {
				balanceMap.put(Coin.getCoin(pickCoin), balanceMap.get(Coin.getCoin(pickCoin)) + 1);
				balance -= pickCoin;
			}
		}
		return balanceMap;
	}

	private static void initializeValue(Map<Coin, Integer> balanceMap) {
		for (Coin coin : Coin.values()) {
			balanceMap.put(coin, 0);
		}
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
}
