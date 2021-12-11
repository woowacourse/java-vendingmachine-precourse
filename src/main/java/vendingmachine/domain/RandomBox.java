package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static vendingmachine.config.ConstantConfig.*;

import java.util.Map;
import java.util.TreeMap;

public enum RandomBox {
	RANDOM_BOX;

	private Map<Integer, Integer> coins;
	private int amount;

	public Map<Integer, Integer> getCoins(int amount) {
		coins = new TreeMap<>();
		this.amount = amount;

		while (this.amount > 0) {
			separateAmountToCoin(pickNumberInList(COIN_LIST));
		}
		return coins;
	}

	private void separateAmountToCoin(int randomCoin) {
		if (amount >= randomCoin) {
			amount -= randomCoin;
			coins.put(randomCoin, coins.getOrDefault(randomCoin, 0) + 1);
		}
	}
}
