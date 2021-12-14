package vendingmachine.model.coin;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static Coin valueOf(int amount) {
		if (amount == 500) {
			return COIN_500;
		} else if (amount == 100) {
			return COIN_100;
		} else if (amount == 50) {
			return COIN_50;
		}
		return COIN_10;
	}

	public static List<Coin> valuesByPriceDesc() {
		return Stream.of(values()).sorted(comparingInt(Coin::getAmount).reversed()).collect(toList());
	}

	public int getAmount() {
		return amount;
	}
}
