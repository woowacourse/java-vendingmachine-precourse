package vendingmachine.service;

import static vendingmachine.domain.Coin.*;

import java.util.HashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;

public class VendingMachineAccountService {

	public static Map<Coin, Integer> setRandomCoins(int amount) {
		Map<Coin, Integer> coinCount = new HashMap<>();
		for (Coin coin : Coin.values()) {
			int randomCount = getRandomCount(amount, coin.getAmount());
			coinCount.put(coin, randomCount);
			amount -= randomCount * coin.getAmount();
		}
		return coinCount;
	}

	private static int getRandomCount(int remainAmount, int coinUnit) {
		int min = 0;
		int max = remainAmount / coinUnit;
		if (coinUnit == COIN_10.getAmount()) {
			min = max;
		}
		return Randoms.pickNumberInRange(min, max);
	}
}
