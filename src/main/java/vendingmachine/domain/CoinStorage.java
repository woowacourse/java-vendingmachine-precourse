package vendingmachine.domain;

import java.util.EnumMap;
import camp.nextstep.edu.missionutils.Randoms;

import lombok.Getter;
import vendingmachine.enums.Coin;

@Getter
public class CoinStorage {
	private static final int DEFAULT_QUANTITY = 0;

	private EnumMap<Coin, Integer> coinMap;

	public CoinStorage(int coinMoney) {
		init();
		randomGenerate(coinMoney);
	}

	private void init() {
		this.coinMap = new EnumMap<Coin, Integer>(Coin.class);
		for(Coin coin : Coin.values()) {
			coinMap.put(coin, DEFAULT_QUANTITY);
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
		coinMap.put(Coin.searchWithAmount(randomCoin), maxQuantity);
	}

	public String toString() {
		return coinMap.toString();
	}
}
