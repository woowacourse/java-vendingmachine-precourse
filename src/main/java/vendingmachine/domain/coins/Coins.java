package vendingmachine.domain.coins;

import java.util.HashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coinamount.CoinAmount;

public class Coins {
	private final Map<Coin, CoinAmount> coins;

	private Coins(int vendingMachineBalance) {
		this.coins = generateRandomCoins(vendingMachineBalance);
	}

	public static Coins create() {
		return new Coins(0);
	}

	public static Coins from(String vendingMachineBalance) {
		CoinsValidator.validateVendingMachineBalance(vendingMachineBalance);

		int parsedBalance = Integer.parseInt(vendingMachineBalance);
		return new Coins(parsedBalance);
	}

	// TODO: 리팩토링 필요
	private Map<Coin, CoinAmount> generateRandomCoins(int vendingMachineBalance) {
		Map<Coin, CoinAmount> coins = new HashMap<>();

		for (int i = 0; i < 3; i++) {
			Coin coin = Coin.values()[i];
			int maxAmount = getMaxCoinAmount(vendingMachineBalance, coin);
			int amount = Randoms.pickNumberInRange(0, maxAmount);
			coins.put(coin, CoinAmount.from(amount));
			vendingMachineBalance -= coin.getAmount() * amount;
		}

		coins.put(Coin.COIN_10, CoinAmount.from(getMaxCoinAmount(vendingMachineBalance, Coin.COIN_10)));
		return coins;
	}

	private int getMaxCoinAmount(int remainingBalance, Coin coin) {
		return remainingBalance / coin.getAmount();
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
