package vendingmachine.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class GreedyCoinPickStrategy implements CoinPickStrategy {

	private ChangeSafe changeSafe;

	public GreedyCoinPickStrategy(ChangeSafe changeSafe) {
		this.changeSafe = changeSafe;
	}

	@Override
	public Coin pickOne(Money money) {
		Coin findCoin = Arrays.stream(Coin.values())
			.filter(coin -> isPickable(coin, money))
			.findAny()
			.orElseThrow(NoSuchElementException::new);
		decrease(findCoin);
		return findCoin;
	}

	private boolean isPickable(Coin coin, Money money) {
		return !coin.toMoney().isGreaterThan(money) && changeSafe.isEnough(coin);
	}

	private void decrease(Coin coin) {
		changeSafe.decrease(coin);
	}
}
