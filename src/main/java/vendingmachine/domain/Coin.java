package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static vendingmachine.constant.Constant.*;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public enum Coin {

	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public static List<Integer> getCoinList() {
		return Arrays.stream(Coin.values())
			.map(Coin::getAmount)
			.collect(Collectors.toList());
	}

	public static Coin pickRandomCoinUnderMoney(int money) {
		int coinValue = pickNumberInList(getCoinList());
		Coin coinPicked = Arrays.stream(Coin.values())
			.filter(coin -> coin.getAmount() == coinValue)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(""));
		if (coinPicked.amount <= money) {
			return coinPicked;
		}
		return pickRandomCoinUnderMoney(money);
	}

	public static int getMinimumCoinUnit() {
		return Arrays.stream(Coin.values())
			.mapToInt(Coin::getAmount)
			.min()
			.orElseThrow(NoSuchElementException::new);
	}

}
