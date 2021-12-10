package vendingmachine.domain.coins;

import java.util.HashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.CoinAmount;
import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.validator.CoinsValidator;

public class Coins {
	private final Map<Coin, CoinAmount> coins;

	private Coins(Map<Coin, CoinAmount> coins) {
		this.coins = coins;
	}

	public static Coins from(String vendingMachineBalance) {
		CoinsValidator.validateVendingMachineBalance(vendingMachineBalance);

		int parsedBalance = Integer.parseInt(vendingMachineBalance);
		Map<Coin, CoinAmount> coins = generateRandomCoins(parsedBalance);

		return new Coins(coins);
	}

	// TODO: 리팩토링 필요
	private static Map<Coin, CoinAmount> generateRandomCoins(int vendingMachineBalance) {
		Map<Coin, CoinAmount> coins = new HashMap<>();
		int remainingBalance = vendingMachineBalance;

		for (int i = 0; i < 3; i++) {
			Coin coin = Coin.values()[i];
			int maxAmount = getMaxCoinAmount(remainingBalance, coin);
			int amount = Randoms.pickNumberInRange(0, maxAmount);
			coins.put(coin, CoinAmount.from(amount));
			remainingBalance -= coin.getAmount() * amount;
		}

		coins.put(Coin.COIN_10, CoinAmount.from(getMaxCoinAmount(remainingBalance, Coin.COIN_10)));
		return coins;
	}

	private static int getMaxCoinAmount(int remainingBalance, Coin coin) {
		return remainingBalance / coin.getAmount();
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
