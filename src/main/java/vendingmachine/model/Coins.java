package vendingmachine.model;

import java.util.EnumMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;

public class Coins {
	private static final int DEFAULT_COIN_NUMBER = 0;
	private static final String DASH = "-";
	private static final String WHITESPACE = " ";
	private static final String LINE_WRAP = "\n";
	private static final String POSTFIX = "개";
	private EnumMap<Coin, Integer> coinMap;

	public Coins(int amount) {
		this.coinMap = new EnumMap<>(Coin.class);
		for (Coin coin : Coin.values()) {
			coinMap.put(coin, DEFAULT_COIN_NUMBER);
		}
		while (amount > 0) {
			Coin coin = selectRandomCoin();

			if (amount >= coin.getAmount()) {
				addCoin(coin);
				amount -= coin.getAmount();
			}
		}
	}

	private void addCoin(Coin coin) {
		coinMap.put(coin, coinMap.get(coin) + 1);
	}

	private Coin selectRandomCoin() {
		return Coin.of(Randoms.pickNumberInList(Stream.of(Coin.values())
			.map(Coin::getAmount)
			.collect(Collectors.toList())));
	}

	public EnumMap<Coin, Integer> calculateChange(int insertMoney) {
		EnumMap<Coin, Integer> changeMap = new EnumMap<>(Coin.class);

		for (Coin coin : coinMap.keySet()) {
			if (coinMap.get(coin) > 0 && coin.isReturnable(insertMoney)) {
				int returningCnt = Math.min(coinMap.get(coin), coin.divideByCoinAmount(insertMoney));
				insertMoney -= coin.multiplyByCoinNumber(returningCnt);
				coinMap.put(coin, coinMap.get(coin) - returningCnt);
				changeMap.put(coin, returningCnt);
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

	public String coinsToString(EnumMap<Coin, Integer> coins) {
		StringBuilder coinsStringBuilder = new StringBuilder();
		coins.keySet()
			.forEach(coin -> coinsStringBuilder.append(coin.toString())
				.append(WHITESPACE)
				.append(DASH)
				.append(WHITESPACE)
				.append(coins.get(coin))
				.append(POSTFIX)
				.append(LINE_WRAP));
		return coinsStringBuilder.toString();
	}
}
