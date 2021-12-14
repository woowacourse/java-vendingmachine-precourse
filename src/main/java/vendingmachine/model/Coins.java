package vendingmachine.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.util.SymbolConstants;

public class Coins {
	private static final int COIN_ADDER = 1;
	private static final String DASH = "-";
	private static final String POSTFIX = "개";
	private Map<Coin, Integer> coinMap;

	public Coins(int amount) {
		this.coinMap = new EnumMap<>(Coin.class);
		for (Coin coin : Coin.values()) {
			coinMap.put(coin, SymbolConstants.ZERO);
		}
		while (amount > SymbolConstants.ZERO) {
			Coin coin = selectRandomCoin();
			if (amount >= coin.getAmount()) {
				addCoin(coin);
				amount -= coin.getAmount();
			}
		}
	}

	private void addCoin(Coin coin) {
		coinMap.put(coin, coinMap.get(coin) + COIN_ADDER);
	}

	private Coin selectRandomCoin() {
		return Coin.of(Randoms.pickNumberInList(Stream.of(Coin.values())
			.map(Coin::getAmount)
			.collect(Collectors.toList())));
	}

	public Map<Coin, Integer> calculateChange(int insertMoney) {
		Map<Coin, Integer> changeMap = new EnumMap<>(Coin.class);
		for (Map.Entry<Coin, Integer> coin : coinMap.entrySet()) {
			if (coin.getValue() > 0 && coin.getKey().isReturnable(insertMoney)) {
				int returningCnt = Math.min(coin.getValue(), coin.getKey().divideByCoinAmount(insertMoney));
				insertMoney -= coin.getKey().multiplyByCoinNumber(returningCnt);
				coinMap.put(coin.getKey(), coin.getValue() - returningCnt);
				changeMap.put(coin.getKey(), returningCnt);
			}
		}
		return changeMap;
	}

	@Override
	public String toString() {
		return coinsToString(this.coinMap);
	}

	public String coinsToString(Map<Coin, Integer> coins) {
		StringBuilder coinsStringBuilder = new StringBuilder();
		coins.keySet()
			.forEach(coin -> coinsStringBuilder.append(coin.toString())
				.append(SymbolConstants.WHITESPACE)
				.append(DASH)
				.append(SymbolConstants.WHITESPACE)
				.append(coins.get(coin))
				.append(POSTFIX)
				.append(SymbolConstants.LINE_WRAP));
		return coinsStringBuilder.toString();
	}
}
