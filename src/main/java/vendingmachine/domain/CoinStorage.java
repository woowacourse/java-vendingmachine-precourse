package vendingmachine.domain;

import java.util.SortedMap;
import java.util.TreeMap;

import vendingmachine.util.supporter.MapSupporter;

public class CoinStorage {
	private final SortedMap<Coin, Integer> coins = new TreeMap<>((c1, c2) -> c2.getAmount() - c1.getAmount());
	private int inputCoinAmount;

	public void addCoins(SortedMap<Coin, Integer> coins) {
		for (Coin coin : coins.keySet()) {
			MapSupporter.increaseCoinCount(this.coins, coin, 0, coins.get(coin));
		}
	}

	public SortedMap<Coin, Integer> getCoins() {
		return this.coins;
	}

	public void addInputCoinAmount(final int amount) {
		this.inputCoinAmount += amount;
	}

	public int getInputCoinAmount() {
		return inputCoinAmount;
	}

	public SortedMap<Coin, Integer> returnCoins() {
		SortedMap<Coin, Integer> returnCoins = new TreeMap<>((c1, c2) -> c2.getAmount() - c1.getAmount());
		int returnCoinsAmount = inputCoinAmount;
		for (Coin coin : coins.keySet()) {
			returnCoinsAmount = setReturnCoinsAndGetReturnCoinsAmount(returnCoins, returnCoinsAmount, coin);
		}
		return returnCoins;
	}

	private int setReturnCoinsAndGetReturnCoinsAmount(SortedMap<Coin, Integer> returnCoins, int returnCoinsAmount,
		Coin coin) {
		for (int i = 0; i < coins.get(coin); i++) {
			if (returnCoinsAmount < coin.getAmount()) {
				break;
			}
			MapSupporter.increaseCoinCount(returnCoins, coin, 0, 1);
			returnCoinsAmount -= coin.getAmount();
		}
		return returnCoinsAmount;
	}

	public int getToTalAmount(SortedMap<Coin, Integer> coins) {
		int totalAmount = 0;
		for (Coin coin : coins.keySet()) {
			totalAmount += coin.getAmount() * coins.get(coin);
		}
		return totalAmount;
	}

	public void decreaseInputCoinAmount(int price) {
		inputCoinAmount -= price;
	}
}
