package vendingmachine.domain;

import java.util.EnumMap;
import camp.nextstep.edu.missionutils.Randoms;

import vendingmachine.enums.Coin;

public class VendingMachineCoin {
	private EnumMap<Coin, Integer> coinStorage;

	public VendingMachineCoin(int coinMoney) {
		init();
		randomGenerate(coinMoney);
	}

	private void init() {
		this.coinStorage = new EnumMap<Coin, Integer>(Coin.class);
		for(Coin coin : Coin.values()) {
			coinStorage.put(coin, 0);
		}
	}

	private void randomGenerate(int coinMoney) {
		while(coinMoney > 0) {
			int randomCoin = getRandomCoin();
			int maxQuantity = getMaxQuantityWithRandomCoin(coinMoney, randomCoin);
			storeCoin(randomCoin, maxQuantity);
			coinMoney -= randomCoin * maxQuantity;
		}
	}

	private int getRandomCoin() {
		return Randoms.pickNumberInList(Coin.getAmountList());
	}

	private int getMaxQuantityWithRandomCoin(int coinMoney, int randomCoin) {
		return coinMoney / randomCoin;
	}

	private void storeCoin(int randomCoin, int maxQuantity) {
		coinStorage.put(Coin.searchWithAmount(randomCoin), maxQuantity);
	}

	public String toString() {
		return coinStorage.toString();
	}
}
