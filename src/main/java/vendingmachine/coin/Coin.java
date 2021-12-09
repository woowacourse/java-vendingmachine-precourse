package vendingmachine.coin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import vendingmachine.Money;

public enum Coin {

	COIN_500(Money.of(500)),
	COIN_100(Money.of(100)),
	COIN_50(Money.of(50)),
	COIN_10(Money.of(10));

	private static final Map<Money, Coin> BY_MONEY = new HashMap<>();

	static {
		for (Coin coin : values()) {
			BY_MONEY.put(coin.money, coin);
		}
	}

	private final Money money;

	Coin(final Money money) {
		this.money = money;
	}

	public static Coin valueOf(Money money) {
		return BY_MONEY.get(money);
	}

	public static List<Integer> getPossibleCoinAmounts(Money money) {
		Set<Money> coinMonies = BY_MONEY.keySet();
		return coinMonies.stream()
			.filter(money::isSpendable)
			.map(Money::getAmount)
			.collect(Collectors.toList());
	}

	public static List<Coin> getCoins() {
		return new ArrayList<>(BY_MONEY.values());
	}

	public Money getMoney() {
		return money;
	}

}
