package vendingmachine.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	public static final int MIN = 10;
	private static final String CURRENCY = "원";
	private static final String ERROR_NO_COIN = "%d 원 동전이 없습니다.";
	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static int pickRandom() {
		List<Integer> amounts = getAmountList();
		return Randoms.pickNumberInList(amounts);
	}

	private static List<Integer> getAmountList() {
		return Arrays.stream(Coin.values()).map(coin -> coin.amount).collect(Collectors.toList());
	}

	public static Coin of(int amount) {
		for (Coin coin : Coin.values()) {
			if (amount == coin.amount) {
				return coin;
			}
		}
		throw new NoSuchElementException(String.format(ERROR_NO_COIN, amount));
	}

	public static Map<Coin, Quantity> createEmpty() {
		return new LinkedHashMap<>(
			Arrays.stream(values())
				.collect(LinkedHashMap::new,
					(map, coin) -> map.put(coin, Quantity.ZERO),
					Map::putAll)
		);
	}

	@Override
	public String toString() {
		return amount + CURRENCY;
	}

	public Money toMoney() {
		return new Money(amount);
	}
}
