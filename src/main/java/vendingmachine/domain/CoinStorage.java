package vendingmachine.domain;

import java.util.EnumMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

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
			coinMap.put(coin, DEFAULT_QUANTITY);
		}
	}

	private void randomGenerate(int coinMoney) {
		List<Integer> coinPool = Coin.getAmountList();
		while(coinMoney > 0) {
			int randomCoin = getRandomCoin(coinPool);
			if(randomCoin <= coinMoney) {
				increaseCoinQuantity(Coin.searchWithAmount(randomCoin));
				coinMoney -= randomCoin;
			}
		}
	}

	private int getRandomCoin(List<Integer> coinList) {
		return Randoms.pickNumberInList(coinList);
	}

	public EnumMap<Coin, Integer> getChange(int remainedMoney) {
		EnumMap<Coin, Integer> changeMap = new EnumMap<Coin, Integer>(Coin.class);
		for(Coin coin : coinMap.keySet()) {
			if(remainedMoney <= 0) {
				break;
			}
			int changeQuantity = calculateChangeQuantity(coin, remainedMoney);
			if(changeQuantity > 0) {
				changeMap.put(coin, changeQuantity);
				coinMap.put(coin, getCoinQuantity(coin) - changeQuantity);
				remainedMoney -= coin.getAmount() * changeQuantity;
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

	private void increaseCoinQuantity(Coin coin) {
		coinMap.put(coin, coinMap.get(coin) + 1);
	}

	public int getCoinQuantity(Coin coin) {
		return coinMap.get(coin);
	}

	public String toString() {
		return coinMap.toString();
	}
}
