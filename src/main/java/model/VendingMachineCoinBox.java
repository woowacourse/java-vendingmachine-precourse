package model;

import java.util.HashMap;
import java.util.Map;

import utils.generator.RandomCoinPriceGenerator;

public class VendingMachineCoinBox {
	private final Map<Coin, Integer> coinBox;

	public VendingMachineCoinBox(int insertVendingMachineChange) {
		coinBox = initCoinBox();
		makeCoins(insertVendingMachineChange);
	}

	private Map<Coin, Integer> initCoinBox() {
		final Map<Coin, Integer> coinBox = new HashMap<>();
		coinBox.put(Coin.COIN_500, 0);
		coinBox.put(Coin.COIN_100, 0);
		coinBox.put(Coin.COIN_50, 0);
		coinBox.put(Coin.COIN_10, 0);
		return coinBox;
	}

	private void makeCoins(int insertVendingMachineChange) {
		int totalCoinPriceInCoinBox = 0;
		while (totalCoinPriceInCoinBox < insertVendingMachineChange) {
			int coinPrice = RandomCoinPriceGenerator.pickRandomCoinPrice();
			if (isTotalCoinPriceOverInputVendingMachineChange(totalCoinPriceInCoinBox, coinPrice,
				insertVendingMachineChange)) {
				continue;
			}
			totalCoinPriceInCoinBox += coinPrice;
			Coin coin = Coin.getCoinByPrice(coinPrice);
			coinBox.put(coin, coinBox.get(coin) + 1);
		}
	}

	private boolean isTotalCoinPriceOverInputVendingMachineChange(int totalCoinPriceInCoinBox, int coinPrice,
		int insertVendingMachineChange) {
		if (totalCoinPriceInCoinBox + coinPrice > insertVendingMachineChange) {
			return true;
		}
		return false;
	}
}
