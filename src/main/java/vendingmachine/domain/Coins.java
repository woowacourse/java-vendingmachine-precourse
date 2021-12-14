package vendingmachine.domain;

import static vendingmachine.domain.Coin.*;

import java.util.EnumMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Coins {
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int MIN_COIN = 10;

	private final EnumMap<Coin, Integer> coinRepository;

	public Coins(int changes) {
		coinRepository = new EnumMap<>(Coin.class);
		createCoins(changes);
	}

	private void createCoins(int changes) {
		for (Coin coin : values()) {
			coinRepository.put(coin, ZERO);
		}
		List<Integer> coinList = Coin.amountValues();
		while (changes > ZERO) {
			int randomCoin = getRandomCoin(coinList, changes);
			changes -= randomCoin;
			Coin coin = valueOf(randomCoin);
			coinRepository.put(coin, getCoinCount(coin) + ONE);
		}
	}

	private int getRandomCoin(List<Integer> coinList, int moneyLeft) {
		int randomCoin = Randoms.pickNumberInList(coinList);
		if (moneyLeft >= randomCoin) {
			return randomCoin;
		}
		return MIN_COIN;
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
