package vendingmachine.domain.machine.coin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.exception.CoinNotFoundMessageException;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static Coin of(int amount) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.isEquals(amount))
			.findAny()
			.orElseThrow(CoinNotFoundMessageException::new);
	}

	private boolean isEquals(int amount) {
		return (this.amount == amount);
	}

	public static List<Coin> getCoinsLessThen(int money) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.isNotBiggerThan(money)).collect(Collectors.toList());
	}

	public boolean isNotBiggerThan(int money) {
		return (amount <= money);
	}

	public boolean isBiggerThan(int money) {
		return !isNotBiggerThan(money);
	}

	public int getAmount() {
		return amount;
	}

}
