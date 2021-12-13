package vendingmachine.domain.coin;

import java.util.Arrays;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.exception.NoMatchingCoinException;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static Coin from(int amount) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.getAmount() == amount)
			.findFirst()
			.orElseThrow(NoMatchingCoinException::new);
	}

	public static Coin pickRandomWithLimit(int balanceLimit) {
		Coin randomCoin = Coin.pickRandom();
		if (randomCoin.getAmount() > balanceLimit) {
			return pickRandomWithLimit(balanceLimit);
		}

		return randomCoin;
	}

	private static Coin pickRandom() {
		int pickedAmount = Randoms.pickNumberInList(
			Arrays.stream(values())
				.map(Coin::getAmount)
				.collect(Collectors.toList())
		);

		return Coin.from(pickedAmount);
	}

	public int getAmount() {
		return amount;
	}
}
