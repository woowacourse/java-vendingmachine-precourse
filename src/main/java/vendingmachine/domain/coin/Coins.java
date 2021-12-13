package vendingmachine.domain.coin;

import java.util.LinkedHashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.machine.Balance;

public class Coins {
	private static final int COIN_AMOUNT_ZERO = 0;
	private static final int COIN_DEFAULT_QUANTITY = 0;
	private static final int COIN_QUANTITY_PLUS = 1;
	private static final int COINS_NUM_DIVISION_STANDARD = 10;
	private static final String ERROR_COINS_AMOUNT_NOT_TEN_PERCENT_DIVISION = "보유금액은 10의 단위로 나누어 떨어져야 합니다.";

	private final Map<Coin, Integer> coins;

	private Coins(Map<Coin, Integer> coins) {
		this.coins = coins;
	}

	public static Coins from(int coinsAmount) {
		isValidateCoinsAmount10PercentDivision(coinsAmount);
		return new Coins(generateRandomCoins(coinsAmount));
	}

	private static void isValidateCoinsAmount10PercentDivision(int coinsAmount) {
		if (coinsAmount % COINS_NUM_DIVISION_STANDARD != COIN_AMOUNT_ZERO) {
			throw new IllegalArgumentException(ERROR_COINS_AMOUNT_NOT_TEN_PERCENT_DIVISION );
		}
	}

	private static Map<Coin, Integer> generateRandomCoins(int inputCoinsAmount) {
		Map<Coin, Integer> randomCoins = initRandomCoins();

		while (inputCoinsAmount != COIN_AMOUNT_ZERO) {
			final int randomCoinAmount = Randoms.pickNumberInList(Coin.getCoinsAmount());
			final Coin randomCoin = Coin.valueOf(randomCoinAmount);

			if (inputCoinsAmount - randomCoinAmount >= COIN_AMOUNT_ZERO) {
				inputCoinsAmount -= randomCoinAmount;
				randomCoins.put(randomCoin, randomCoins.get(randomCoin) + COIN_QUANTITY_PLUS);
			}
		}

		return randomCoins;
	}

	private static Map<Coin, Integer> initRandomCoins() {
		Map<Coin, Integer> initCoins = new LinkedHashMap<>();
		for (Coin coin : Coin.values()) {
			initCoins.put(coin, COIN_DEFAULT_QUANTITY);
		}

		return initCoins;
	}

	public Coins calculateReturnCoins(Balance balance) {
		Map<Coin, Integer> returnCoins = new LinkedHashMap<>();
		int currentBalance = balance.getBalance();

		for (Coin coin : coins.keySet()) {
			int coinValue = getCoinValue(coin, currentBalance);
			currentBalance -= coin.getAmount() * coinValue;

			if (coinValue != COIN_AMOUNT_ZERO) {
				returnCoins.put(coin, coinValue);
			}
		}

		return new Coins(returnCoins);
	}

	private int getCoinValue(Coin coin, int currentBalance) {
		final int amount = coin.getAmount();
		int calculateValue = currentBalance / amount;
		if (calculateValue > coins.get(coin)) {
			calculateValue = coins.get(coin);
		}

		return calculateValue;
	}

	public Map<Coin, Integer> getCoins() {
		return coins;
	}
}
