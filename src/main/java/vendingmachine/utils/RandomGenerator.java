package vendingmachine.utils;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;

public class RandomGenerator {

	public static Map<Coin, Integer> getHoldingCoin(int holdingAmount) {
		Map<Coin, Integer> holdingCoin = new EnumMap<Coin, Integer>(Coin.class);
		while (holdingAmount != 0) {
			int randomCoin = getRandomCoin(holdingAmount);
			Coin nowCoin = Stream.of(Coin.values())
				.filter(e -> e.getAmount() == randomCoin)
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
			holdingAmount -= randomCoin;
			holdingCoin.put(nowCoin, holdingCoin.getOrDefault(nowCoin, 0) + 1);
		}
		return holdingCoin;
	}

	public static int getRandomCoin(int remainingAmount) {
		int randomCoin = Randoms.pickNumberInList(Stream.of(Coin.values())
			.map(Coin::getAmount)
			.collect(Collectors.toList()));
		if (remainingAmount < randomCoin) {
			return getRandomCoin(remainingAmount);
		}
		return randomCoin;
	}
}
