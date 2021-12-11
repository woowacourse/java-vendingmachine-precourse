package vendingmachine.domain;

import java.util.EnumMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

import lombok.Getter;
import vendingmachine.enums.Coin;

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
			putCoinQuantity(coin, DEFAULT_QUANTITY);
		}
	}

	private void randomGenerate(int coinMoney) {
		List<Integer> coinPool = Coin.getAmountList();
		while(coinMoney > 0) {
			int randomCoin = getRandomCoin(coinPool);
			int maxQuantity = calculateMaxQuantity(coinMoney, randomCoin);
			putCoinQuantity(Coin.searchWithAmount(randomCoin), maxQuantity);
			coinMoney -= randomCoin * maxQuantity;
			coinPool.remove((Integer) randomCoin);
		}
	}

	private int getRandomCoin(List<Integer> coinList) {
		return Randoms.pickNumberInList(coinList);
	}

	public EnumMap<Coin, Integer> getChange(int remainedMoney) {
		EnumMap<Coin, Integer> changeMap = new EnumMap<Coin, Integer>(Coin.class);
		for(Coin coin : coinMap.keySet()) {
			int changeQuantity = calculateChangeQuantity(coin, remainedMoney);
			if(changeQuantity > 0) {
				changeMap.put(coin, changeQuantity);
				putCoinQuantity(coin, getCoinQuantity(coin) - changeQuantity);
			}
		}
		return changeMap;
	}

	private int calculateChangeQuantity(Coin coin, int remainedMoney) {
		int maxQuantity = calculateMaxQuantity(remainedMoney, coin.getAmount());
		int quantity = getCoinQuantity(coin);
		return Math.min(maxQuantity, quantity);
	}

	private int calculateMaxQuantity(int coinMoney, int randomCoin) {
		return coinMoney / randomCoin;
	}

	private void putCoinQuantity(Coin coin, int maxQuantity) {
		coinMap.put(coin, maxQuantity);
	}

	public int getCoinQuantity(Coin coin) {
		return coinMap.get(coin);
	}

	public String toString() {
		return coinMap.toString();
	}
}
