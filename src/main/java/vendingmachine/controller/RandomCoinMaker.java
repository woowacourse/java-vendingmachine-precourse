package vendingmachine.controller;

import static vendingmachine.Constant.*;

import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;

public class RandomCoinMaker {

	public static HashMap<Coin, Integer> makeRandomCoin(int money) {
		List<Integer> coinList = Coin.getIntCoinList();
		HashMap<Coin, Integer> countCoin = initCountCoin();
		int sum = 0;
		int tmpMoney = money;
		while (sum != money - (money % TO_THROW_ONE_UNIT)) {
			int coin = Randoms.pickNumberInList(coinList);
			if (tmpMoney >= coin) {
				countCoin.put(Coin.getCoinByAmount(coin), countCoin.get(Coin.getCoinByAmount(coin)) + 1);
				sum += coin;
				tmpMoney -= coin;
			}
		}
		return countCoin;
	}

	public static HashMap<Coin, Integer> initCountCoin() {
		HashMap<Coin, Integer> countCoin = new HashMap<>();
		for (Coin coin : Coin.getCoinArray()) {
			countCoin.put(coin, 0);
		}
		return countCoin;
	}
}
