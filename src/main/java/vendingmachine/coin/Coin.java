package vendingmachine.coin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import vendingmachine.Amount;

public enum Coin {

	COIN_500(Amount.of(500)),
	COIN_100(Amount.of(100)),
	COIN_50(Amount.of(50)),
	COIN_10(Amount.of(10));

	private static final Map<Amount, Coin> BY_AMOUNT = new HashMap<>();

	static {
		for (Coin coin : values()) {
			BY_AMOUNT.put(coin.amount, coin);
		}
	}

	private final Amount amount;

	Coin(final Amount amount) {
		this.amount = amount;
	}

	public static Coin valueOf(Amount amount) {
		return BY_AMOUNT.get(amount);
	}

	public static List<Integer> getPossibleAmounts(Amount amount) {
		Set<Amount> coinAmounts = BY_AMOUNT.keySet();
		return coinAmounts.stream()
			.filter(amount::isSpendable)
			.map(Amount::getAmount)
			.collect(Collectors.toList());
	}

	public Amount getAmount() {
		return amount;
	}

}
