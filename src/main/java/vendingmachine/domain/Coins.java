package vendingmachine.domain;

import static vendingmachine.domain.Coin.*;

import java.util.EnumMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class Coins {
	private static final int ZERO = 0;

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
		return Randoms.pickNumberInList(
			IntStream.rangeClosed(ZERO, changes / value).boxed().collect(Collectors.toList()));
	}

	public int getCoinCount(Coin coin) {
		return coinRepository.get(coin);
	}
}
