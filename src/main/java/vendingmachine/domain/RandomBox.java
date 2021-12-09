package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static vendingmachine.utils.Constant.*;

import java.util.Map;
import java.util.TreeMap;

public enum RandomBox {
	RANDOM_COIN_BOX;

	private Map<Integer, Integer> coins;
	private int amount;

	public Map<Integer, Integer> getNumOfCoins(int amount) {
		coins = new TreeMap<>();
		this.amount = amount;

		while (amount > 0) {
			isAmountMoreThanCoin(pickNumberInList(COIN_LIST));
		}

		return coins;
	}

	private void isAmountMoreThanCoin(int randomCoin) {
		if (amount >= randomCoin) {
			amount -= randomCoin;
			coins.put(randomCoin, coins.getOrDefault(randomCoin, 0) + 1);
		}
	}
}
