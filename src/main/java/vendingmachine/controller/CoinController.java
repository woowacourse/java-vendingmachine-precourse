package vendingmachine.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;

public class CoinController {
	private Map<Coin, Integer> coins = new HashMap<>();

	public Map<Coin, Integer> setCoinsByBalance(int balance) {
		List<Integer> coinList = new ArrayList<>();
		for (Coin coin : Coin.values()) {
			coinList.add(coin.getAmount());
			coins.put(coin, 0);
		}
		while(balance > 0) {
			int coinUnit = gatherCoin(balance, coinList);
			updateCoinQuantity(coinUnit);
			balance -= coinUnit;
		}
		return coins;
	}

	private int gatherCoin(int balance, List<Integer> coinList) {
		if (balance < Collections.max(coinList)) {
			coinList.remove(0);
		}
		return Randoms.pickNumberInList(coinList);
	}

	private void updateCoinQuantity(int coinUnit) {
		Coin coin = Coin.valueOf("COIN_" + coinUnit);
		int previousQuantity = coins.get(coin);
		coins.put(coin, previousQuantity + 1);
	}

}
