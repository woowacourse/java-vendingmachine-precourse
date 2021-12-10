package vendingmachine.domain.coin;

import java.util.Arrays;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

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
		if (amount == COIN_500.getAmount()) {
			return COIN_500;
		}

		if (amount == COIN_100.getAmount()) {
			return COIN_100;
		}

		if (amount == COIN_50.getAmount()) {
			return COIN_50;
		}

		return COIN_10;
	}

	public static Coin pickRandom() {
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

	// 추가 기능 구현
}
