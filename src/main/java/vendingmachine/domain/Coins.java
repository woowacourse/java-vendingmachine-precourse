package vendingmachine.domain;

import static vendingmachine.domain.Coin.*;

import java.util.EnumMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class Coins {
	private static final int ZERO = 0;
	private static final int MIN_COIN = 10;

	private final EnumMap<Coin, Integer> coinRepository;

	public Coins(int changes) {
		coinRepository = new EnumMap<>(Coin.class);
		putCoins(changes);
	}

	private void putCoins(int changes) {
		for (Coin coin : values()) {
			int count = createCoin(changes, coin.getAmount());
			changes -= coin.getAmount() * count;
			coinRepository.put(coin, count);
		}
	}

	private int createCoin(int changes, int value) {
		if (value == MIN_COIN) {
			return changes / value;
		}
		return Randoms.pickNumberInList(
			IntStream.rangeClosed(ZERO, changes / value).boxed().collect(Collectors.toList()));
	}

	public int getCoinCount(Coin coin) {
		return coinRepository.get(coin);
	}

	public EnumMap<Coin, Integer> changeCoins(int moneyLeft) {
		if (!returnable(moneyLeft)) {
			return coinRepository;
		}

		EnumMap<Coin, Integer> coins = new EnumMap<>(Coin.class);
		for (Coin coin : values()) {
			int count = getCoinCount(moneyLeft, coin);
			moneyLeft -= coin.getAmount() * count;
			coins.put(coin, count);
		}
		return coins;
	}

	private int getCoinCount(int changes, Coin coin) {
		int count = changes / coin.getAmount();
		if (count > coinRepository.get(coin)) {
			return coinRepository.get(coin);
		}
		return count;
	}

	private boolean returnable(int moneyLeft) {
		int sum = 0;
		for (Coin coin : values()) {
			sum += coin.getAmount() * coinRepository.get(coin);
		}
		return sum >= moneyLeft;
	}
}
