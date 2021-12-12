package model;

import java.util.HashMap;
import java.util.Map;

import utils.generator.RandomCoinPriceGenerator;

public class VendingMachineCoinBox {
	private final Map<Coin, Integer> coinBox;

	public VendingMachineCoinBox(int inputVendingMachineChange) {
		coinBox = initCoinBox();
		makeCoins(inputVendingMachineChange);
	}

	private Map<Coin, Integer> initCoinBox() {
		final Map<Coin, Integer> coinBox = new HashMap<>();
		coinBox.put(Coin.COIN_500, 0);
		coinBox.put(Coin.COIN_100, 0);
		coinBox.put(Coin.COIN_50, 0);
		coinBox.put(Coin.COIN_10, 0);
		return coinBox;
	}

	private void makeCoins(int inputVendingMachineChange) {
		int totalCoinPriceInCoinBox = 0;
		while (totalCoinPriceInCoinBox < inputVendingMachineChange) {
			int coinPrice = RandomCoinPriceGenerator.pickRandomCoinPrice();
			if (isTotalCoinPriceOverInputVendingMachineChange(totalCoinPriceInCoinBox, coinPrice,
				inputVendingMachineChange)) {
				continue;
			}
			totalCoinPriceInCoinBox += coinPrice;
			Coin coin = Coin.getCoinByPrice(coinPrice);
			coinBox.put(coin, coinBox.get(coin) + 1);
		}
	}

	private boolean isTotalCoinPriceOverInputVendingMachineChange(int totalCoinPriceInCoinBox, int coinPrice,
		int inputVendingMachineChange) {
		if (totalCoinPriceInCoinBox + coinPrice > inputVendingMachineChange) {
			return true;
		}
		return false;
	}
}
