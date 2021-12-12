package vendingmachine.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Changes {

	private final static int START_NUMBER_ZERO = 0;
	private final static int ADD_ONE = 1;

	private HashMap<Coin, Integer> coinMap = new HashMap<>();
	// 변수명 바꾸기
	private int totalAmount;

	Changes(int totalAmount) {
		this.totalAmount = totalAmount;
		initCoinMap();
	}

	public List<Coin> getRemainChanges() {
		List<Coin> remainCoinList = new ArrayList<>();

		for (Coin coin : Coin.values()) {
			if (coinMap.get(coin) != START_NUMBER_ZERO) {
				remainCoinList.add(coin);
			}
		}
		return remainCoinList;
	}

	public HashMap<Coin, Integer> getCoinMap() {
		return coinMap;
	}

	public void createRandomCoin() {
		while (totalAmount > START_NUMBER_ZERO) {
			int number = Randoms.pickNumberInList(Coin.getCoinList());

			if (totalAmount >= number) {
				Coin randomCoin = Coin.getCoinByNumber(number);
				coinMap.put(randomCoin, coinMap.get(randomCoin) + ADD_ONE);
				totalAmount -= number;
			}
		}
	}

	private void initCoinMap() {
		for (Coin coin : Coin.values()) {
			coinMap.put(coin, START_NUMBER_ZERO);
		}
	}

}
