package vendingmachine.domain.coin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import vendingmachine.domain.money.Money;
import vendingmachine.domain.quantity.Quantity;

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

	public static Optional<Coin> valueOf(Money money) {
		return Optional.ofNullable(BY_MONEY.get(money));
	}

	public static List<Integer> getExchangeableCoinAmounts(Money money) {
		Set<Money> coinMonies = BY_MONEY.keySet();
		return coinMonies.stream()
			.filter(money::isSpendable)
			.map(Money::getAmount)
			.collect(Collectors.toList());
	}

	public static List<Coin> getSortedCoins() {
		ArrayList<Coin> coins = new ArrayList<>(BY_MONEY.values());
		coins.sort((o1, o2) -> o2.money.compareTo(o1.money));
		return coins;
	}

	public Money getMoney() {
		return money;
	}

	@Override
	public String toString() {
		return money.toString();
	}

	public Quantity exchangeableQuantity(Money money, Quantity quantity) {
		int ableQuantity = money.getAmount() / this.money.getAmount();
		int returnQuantity = Math.min(ableQuantity, quantity.getCount());
		return Quantity.of(returnQuantity);
	}
}
