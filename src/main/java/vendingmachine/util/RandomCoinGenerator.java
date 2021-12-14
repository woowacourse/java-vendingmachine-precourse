package vendingmachine.util;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.List;

import vendingmachine.domain.coin.Coin;

public class RandomCoinGenerator {
	public static Coin pickRandomCoinAmount(int amount) {
		int randomCoinAmount;
		List<Integer> allCoinAmount = Coin.getAllCoinAmount();
		do {
			randomCoinAmount = pickNumberInList(allCoinAmount);
		}
		while (amount < randomCoinAmount);
		return Coin.getCoinByAmount(randomCoinAmount);
	}
}
