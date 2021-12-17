package vendingmachine.repository;

import static vendingmachine.util.InputCondition.*;

import java.util.List;
import java.util.TreeMap;

import vendingmachine.domain.Coin;
import vendingmachine.util.Symbol;
import vendingmachine.util.comparator.CoinComparator;

public class CoinRepository {
	private final TreeMap<Coin, Integer> coinMap;

	public CoinRepository() {
		this.coinMap = new TreeMap<>();
		initCoinKind(Coin.getCoinList());
	}

	private void initCoinKind(List<Coin> coin) {
		coin.stream().forEach(c -> coinMap.put(c, 0));
	}

	public void addCoin(Coin coin) {
		coinMap.put(coin, coinMap.getOrDefault(coin, 0) + 1);
	}

	public String getCurrentMachineCoin() {
		return getCurrentCoin(coinMap);
	}

	private String getCurrentCoin(TreeMap<Coin, Integer> coins) {
		StringBuilder builder = new StringBuilder();
		coins.keySet().stream()
			.forEach(
				c -> builder.append(
					c.getAmount() + Symbol.WON + Symbol.HYPHEN_SPACE + coins.get(c) + Symbol.COUNT + Symbol.MEW_LINE));
		return builder.toString();
	}

	public String subtractCoins(int payMoney) {
		TreeMap<Coin, Integer> smallChange = new TreeMap<>(new CoinComparator());
		for (Coin coin : Coin.getCoinList()) {
			payMoney = subtract(coin, payMoney, smallChange);
		}
		return getCurrentCoin(smallChange);
	}

	private int subtract(Coin coin, int payMoney, TreeMap<Coin, Integer> smallChange) {
		while (payMoney >= coin.getAmount() && coinMap.get(coin) > ZERO) {
			smallChange.put(coin, smallChange.getOrDefault(coin, 0) + 1);
			coinMap.put(coin, coinMap.get(coin) - 1);
			payMoney -= coin.getAmount();
		}
		return payMoney;
	}
}
