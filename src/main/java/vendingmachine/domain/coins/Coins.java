package vendingmachine.domain.coins;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.CoinAmount;
import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.domain.vendingmachinebalance.VendingMachineBalance;

public class Coins {
	private final Map<Coin, CoinAmount> coins;

	private Coins(Map<Coin, CoinAmount> coins) {
		this.coins = coins;
	}

	public static Coins from(VendingMachineBalance vendingMachineBalance) {
		Map<Coin, CoinAmount> coins = generateRandomCoins(vendingMachineBalance);
		return new Coins(coins);
	}

	// TODO: 리팩토링 필요
	private static Map<Coin, CoinAmount> generateRandomCoins(VendingMachineBalance vendingMachineBalance) {
		Map<Coin, CoinAmount> coins = new HashMap<>();
		int remainingBalance = vendingMachineBalance.toInt();

		while (remainingBalance > 0) {
			Coin randomCoin = Coin.pickRandom();
			if (!isAbleToAddChange(randomCoin, remainingBalance)) {
				continue;
			}
			coins.computeIfAbsent(randomCoin, coin -> CoinAmount.from(0));
			coins.put(randomCoin, CoinAmount.from(coins.get(randomCoin).toInt() + 1));
			remainingBalance = remainingBalance - randomCoin.getAmount();
		}

		return coins;
	}

	private static boolean isAbleToAddChange(Coin coin, int balance) {
		return coin.getAmount() <= balance;
	}

	// TODO: 리팩토링 필요
	public Coins getChange(UserBalance userBalance) {
		Map<Coin, CoinAmount> coins = new HashMap<>();
		int remainingBalance = userBalance.toInt();

		for (int i = 0; i < Coin.values().length; i++) {
			Coin coin = Coin.values()[i];
			int quantity = getCoinQuantityForChange(coin, remainingBalance);
			coins.put(coin, CoinAmount.from(quantity));
			remainingBalance = remainingBalance - (coin.getAmount() * quantity);
		}

		return new Coins(coins);
	}

	private int getCoinQuantityForChange(Coin coin, int balance) {
		int maxCoinQuantityForChange = getMaxCoinQuantityForChange(coin, balance);
		int holdingQuantity = getCoinAmount(coin).toInt();

		if (maxCoinQuantityForChange < holdingQuantity) {
			return maxCoinQuantityForChange;
		}

		return holdingQuantity;
	}

	private int getMaxCoinQuantityForChange(Coin coin, int balance) {
		return balance / coin.getAmount();
	}

	public CoinAmount getCoinAmount(Coin coin) {
		CoinAmount coinAmount = coins.get(coin);
		if (coinAmount != null) {
			return coinAmount;
		}

		return CoinAmount.from(0);
	}

	@Override
	public String toString() {
		return coins.toString();
	}
}
