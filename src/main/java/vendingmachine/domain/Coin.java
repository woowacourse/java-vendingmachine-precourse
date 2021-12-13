package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
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

	public long subtractAmountFrom(long money) {
		return money - this.amount;
	}

	public static Coin randomCoinFrom(long money) {
		int coinAmount = getRandomValidAmount(money);
		return findCoinByAmount(coinAmount);
	}

	@Override
	public String toString() {
		return String.valueOf(amount);
	}

	public int calculateMaxCount(long money) {
		return (int)money / amount;
	}

	public int multipleCount(int count) {
		return amount * count;
	}

	private static int getRandomValidAmount(long money) {
		int coinAmount;
		do {
			coinAmount = Randoms.pickNumberInList(coinAmountList());
		} while (coinAmount > money);
		return coinAmount;
	}

	private static List<Integer> coinAmountList() {
		return Arrays.asList(Coin.values()).stream()
			.map(coin -> coin.amount)
			.collect(Collectors.toList());
	}

	private static Coin findCoinByAmount(int amount) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.amount == amount)
			.findFirst().get();
	}
}
