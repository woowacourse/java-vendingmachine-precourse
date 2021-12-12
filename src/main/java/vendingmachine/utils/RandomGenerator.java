package vendingmachine.utils;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;

public class RandomGenerator {

	public static Map<Coin, Integer> getHoldingCoin(int holdingAmount) {
		Map<Coin, Integer> holdingCoin = Coin.getCoin();

		int remainingAmount = holdingAmount;
		while (remainingAmount > 0) {
			Coin coin = getRandomCoin(remainingAmount);
			remainingAmount -= coin.getAmount();
			holdingCoin.put(coin, holdingCoin.get(coin) + 1);
		}
		return holdingCoin;
	}

	public static Coin getRandomCoin(int remainingAmount) {
		int randomCoin = Randoms.pickNumberInList(Stream.of(Coin.values())
			.map(Coin::getAmount)
			.filter(e -> e <= remainingAmount)
			.collect(Collectors.toList()));
		Optional<Coin> coin = Stream.of(Coin.values())
			.filter(e -> e.getAmount() == randomCoin)
			.findFirst();
		return coin.orElseGet(() -> getRandomCoin(remainingAmount));
	}
}
