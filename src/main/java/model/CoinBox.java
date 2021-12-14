package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import utils.generator.RandomCoinPriceGenerator;

public class CoinBox {
	private static final int INITIAL_COIN_COUNT = 0;
	private static final int INITIAL_TOTAL_COIN_PRICE = 0;
	private static final int ADD_COIN_COUNT = 1;

	private final Map<Coin, Integer> coinBox;

	public CoinBox(int change) {
		coinBox = initCoinBox();
		makeCoins(change);
	}

	private Map<Coin, Integer> initCoinBox() {
		final Map<Coin, Integer> coinBox = new HashMap<>();
		coinBox.put(Coin.COIN_500, INITIAL_COIN_COUNT);
		coinBox.put(Coin.COIN_100, INITIAL_COIN_COUNT);
		coinBox.put(Coin.COIN_50, INITIAL_COIN_COUNT);
		coinBox.put(Coin.COIN_10, INITIAL_COIN_COUNT);
		return coinBox;
	}

	private void makeCoins(int change) {
		int totalCoinPriceInCoinBox = INITIAL_TOTAL_COIN_PRICE;
		while (totalCoinPriceInCoinBox < change) {
			int coinPrice = RandomCoinPriceGenerator.pickRandomCoinPrice();
			if (isTotalCoinPriceOverChange(totalCoinPriceInCoinBox, coinPrice, change)) {
				continue;
			}
			totalCoinPriceInCoinBox += coinPrice;
			Coin coin = Coin.getValueByPrice(coinPrice);
			coinBox.put(coin, coinBox.get(coin) + ADD_COIN_COUNT);
		}
	}

	private boolean isTotalCoinPriceOverChange(int totalCoinPriceInCoinBox, int coinPrice, int change) {
		return totalCoinPriceInCoinBox + coinPrice > change;
	}

	public List<Integer> getCountOfEachCoins() {
		List<Integer> countOfEachCoins = new ArrayList<>();
		for (Coin coin : Coin.getValuesByDescending()) {
			countOfEachCoins.add(coinBox.get(coin));
		}
		return countOfEachCoins;
	}

	public List<Integer> getPriceOfEachCoins() {
		List<Integer> priceOfEachCoins = new ArrayList<>();
		for (Coin coin : Coin.getValuesByDescending()) {
			priceOfEachCoins.add(coin.getAmount());
		}
		return priceOfEachCoins;
	}

	public Map<Integer, Integer> getChangeCoins(int insertedMoney) {
		Map<Integer, Integer> changeCoins = new TreeMap<>(Collections.reverseOrder());
		for (Coin coin : Coin.getValuesByDescending()) {
			int coinCount = getCoinsEqualToCoinPrice(coin, insertedMoney);
			if (coinCount > 0) {
				changeCoins.put(coin.getAmount(), coinCount);
			}
		}
		return changeCoins;
	}

	private int getCoinsEqualToCoinPrice(Coin coin, int insertedMoney) {
		int coinCount = 0;
		while (hasCoinInCoinBox(coin) && !isCoinPriceOverInsertedMoney(coin, insertedMoney)) {
			insertedMoney -= coin.getAmount();
			coinBox.put(coin, coinBox.get(coin) - 1);
			coinCount += 1;
		}
		return coinCount;
	}

	private boolean hasCoinInCoinBox(Coin coin) {
		return coinBox.get(coin) >= 1;
	}

	private boolean isCoinPriceOverInsertedMoney(Coin coin, int insertedMoney) {
		return coin.getAmount() > insertedMoney;
	}
}
