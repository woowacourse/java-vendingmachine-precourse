package vendingmachine.model;

import java.util.EnumMap;

import camp.nextstep.edu.missionutils.Randoms;

public class Coins {
	private static final String DASH = "-";
	private static final String WHITESPACE = " ";
	private static final String LINE_WRAP = "\n";
	private static final String POSTFIX = "개";
	private EnumMap<Coin, Integer> coinMap;

	public Coins(int amount) {
		this.coinMap = new EnumMap<>(Coin.class);
		while (amount > 0) {
			Coin coin = selectCoinType();
			int coinNumber = generateRandomValueInRange(coin.divideByCoinAmount(amount));
			coinMap.put(coin, coinMap.getOrDefault(coin, 0) + coinNumber);
			amount -= coin.multiplyByCoinNumber(coinNumber);
		}
	}

	private int generateRandomValueInRange(int endInclusive) {
		return Randoms.pickNumberInRange(0, endInclusive);
	}

	private Coin selectCoinType() {
		int coinIndex = Randoms.pickNumberInRange(0, Coin.values().length - 1);
		return Coin.values()[coinIndex];
	}

	public EnumMap<Coin, Integer> calculateChange(int insertMoney) {
		EnumMap<Coin, Integer> changeMap = new EnumMap<>(Coin.class);
		for (Coin coin: coinMap.keySet()) {
			int coinNumber = coin.divideByCoinAmount(insertMoney);
			if (coinNumber > 0 && coinMap.get(coin) >= coinNumber) {
				insertMoney -= coin.multiplyByCoinNumber(coinNumber);
				coinMap.put(coin, coinMap.get(coin) - coinNumber);
				changeMap.put(coin, coinNumber);
			}
		}
		return changeMap;
	}

	@Override
	public String toString() {
		StringBuilder coinsStringBuilder = new StringBuilder();
		coinMap.keySet()
			.forEach(coin -> coinsStringBuilder.append(coin.toString())
				.append(WHITESPACE)
				.append(DASH)
				.append(WHITESPACE)
				.append(coinMap.get(coin))
				.append(POSTFIX)
				.append(LINE_WRAP));
		return coinsStringBuilder.toString();
	}
}
