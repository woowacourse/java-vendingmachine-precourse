package model.coin;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import model.coin.Coin;
import utils.generator.RandomCoinPriceGenerator;

public class CoinBox {
	private static final int INITIAL_COIN_COUNT = 0;
	private static final int INITIAL_TOTAL_COIN_PRICE = 0;
	private static final int MIN_COIN_COUNT = 1;
	private static final int ADD_COIN_COUNT = 1;
	private static final int MINUS_COIN_COUNT = 1;

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

	public Map<Integer, Integer> getAllOfEachCoins() {
		Map<Integer, Integer> eachCoins = new TreeMap<>(Collections.reverseOrder());
		for (Coin coin : Coin.getValues()) {
			eachCoins.put(coin.getAmount(), coinBox.get(coin));
		}
		return eachCoins;
	}

	public Map<Integer, Integer> getChangeCoins(int insertedMoney) {
		Map<Integer, Integer> changeCoins = new TreeMap<>(Collections.reverseOrder());
		for (Coin coin : Coin.getValues()) {
			int coinCount = getCoinsEqualToCoinPrice(coin, insertedMoney);
			if (coinCount >= MIN_COIN_COUNT) {
				changeCoins.put(coin.getAmount(), coinCount);
			}
		}
		return changeCoins;
	}

	private int getCoinsEqualToCoinPrice(Coin coin, int insertedMoney) {
		int coinCount = INITIAL_COIN_COUNT;
		while (hasCoinInCoinBox(coin) && !isCoinPriceOverInsertedMoney(coin, insertedMoney)) {
			insertedMoney -= coin.getAmount();
			coinBox.put(coin, coinBox.get(coin) - MINUS_COIN_COUNT);
			coinCount += ADD_COIN_COUNT;
		}
		return coinCount;
	}

	private boolean hasCoinInCoinBox(Coin coin) {
		return coinBox.get(coin) >= MINUS_COIN_COUNT;
	}

	private boolean isCoinPriceOverInsertedMoney(Coin coin, int insertedMoney) {
		return coin.getAmount() > insertedMoney;
	}
}
