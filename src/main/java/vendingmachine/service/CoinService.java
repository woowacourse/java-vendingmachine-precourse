package vendingmachine.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;

public class CoinService {

	private static final String COIN_PREFIX = "COIN_";

	public HashMap<Coin, Integer> getRandomCoins(List<Coin> coins, int savedMoney) {
		HashMap<Coin, Integer> savedCoin = new HashMap<>();
		while (savedMoney > 0) {
			int pickedCoin = getPickedCoin(coins, savedMoney);
			Coin keyCoin = Coin.valueOf(COIN_PREFIX + Integer.toString(pickedCoin));
			validateEmptyCoin(savedCoin, keyCoin);
			Integer numberOfCoin = savedCoin.get(keyCoin);
			savedCoin.put(keyCoin, numberOfCoin + 1);
			savedMoney -= pickedCoin;
		}
		return savedCoin;
	}

	private int getPickedCoin(List<Coin> coins, int savedMoney) {
		return Randoms.pickNumberInList(coins.stream()
			.map(Coin::getAmount)
			.filter(amount -> amount <= savedMoney)
			.collect(Collectors.toList()));
	}

	private void validateEmptyCoin(HashMap<Coin, Integer> savedCoin, Coin keyCoin) {
		if (!savedCoin.containsKey(keyCoin)) {
			savedCoin.put(keyCoin, 0);
		}
	}
}
