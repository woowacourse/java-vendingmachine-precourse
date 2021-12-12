package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.generator.RandomCoinPriceGenerator;

public class VendingMachineCoinBox {
	private static final int START_COIN_COUNT = 0;
	private static final int START_TOTAL_COIN_PRICE = 0;
	private static final int ADD_COIN_COUNT = 1;
	private final Map<Coin, Integer> coinBox;

	public VendingMachineCoinBox(int insertVendingMachineChange) {
		coinBox = initCoinBox();
		makeCoins(insertVendingMachineChange);
	}

	private Map<Coin, Integer> initCoinBox() {
		final Map<Coin, Integer> coinBox = new HashMap<>();
		coinBox.put(Coin.COIN_500, START_COIN_COUNT);
		coinBox.put(Coin.COIN_100, START_COIN_COUNT);
		coinBox.put(Coin.COIN_50, START_COIN_COUNT);
		coinBox.put(Coin.COIN_10, START_COIN_COUNT);
		return coinBox;
	}

	private void makeCoins(int insertVendingMachineChange) {
		int totalCoinPriceInCoinBox = START_TOTAL_COIN_PRICE;
		while (totalCoinPriceInCoinBox < insertVendingMachineChange) {
			int coinPrice = RandomCoinPriceGenerator.pickRandomCoinPrice();
			if (isTotalCoinPriceOverInputVendingMachineChange(totalCoinPriceInCoinBox, coinPrice,
				insertVendingMachineChange)) {
				continue;
			}
			totalCoinPriceInCoinBox += coinPrice;
			Coin coin = Coin.getValueByPrice(coinPrice);
			coinBox.put(coin, coinBox.get(coin) + ADD_COIN_COUNT);
		}
	}

	private boolean isTotalCoinPriceOverInputVendingMachineChange(int totalCoinPriceInCoinBox, int coinPrice,
		int insertVendingMachineChange) {
		if (totalCoinPriceInCoinBox + coinPrice > insertVendingMachineChange) {
			return true;
		}
		return false;
	}

	public List<Integer> bringEachCoinCountInCoinBox() {
		List<Integer> eachCoinCount = new ArrayList<>();
		for (Coin coin : Coin.getValuesByDescending()) {
			eachCoinCount.add(coinBox.get(coin));
		}
		return eachCoinCount;
	}

	public List<Integer> bringEachCoinValueInCoinBox() {
		List<Integer> eachCoinValue = new ArrayList<>();
		for (Coin coin : Coin.getValuesByDescending()) {
			eachCoinValue.add(coin.getAmount());
		}
		return eachCoinValue;
	}
}
