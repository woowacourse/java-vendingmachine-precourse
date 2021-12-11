package vendingmachine.domain;

import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class Changes {

	private final static int START_NUMBER_ZERO = 0;
	private final static int ADD_ONE = 1;

	private HashMap<Coin, Integer> coinMap = new HashMap<>();
	private int inputMoney;

	Changes(int inputMoney) {
		this.inputMoney = inputMoney;
		initCoinMap();
	}

	public HashMap<Coin, Integer> getCoinMap() {
		return coinMap;
	}

	public void createRandomCoin() {
		while (inputMoney > START_NUMBER_ZERO) {
			int number = Randoms.pickNumberInList(Coin.getCoinList());

			if (inputMoney >= number) {
				Coin randomCoin = Coin.getCoinByNumber(number);
				coinMap.put(randomCoin, coinMap.get(randomCoin) + ADD_ONE);
				inputMoney -= number;
			}
		}
	}

	private void initCoinMap() {
		for (Coin coin : Coin.values()) {
			coinMap.put(coin, START_NUMBER_ZERO);
		}
	}

}
