package vendingmachine.domain;

import static vendingmachine.util.InputCondition.*;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import vendingmachine.util.Symbol;
import vendingmachine.util.comparator.CoinComparator;

public class Coins {
	private final TreeMap<Coin, Integer> coinMap;

	public Coins(List<Integer> coin) {
		this.coinMap = new TreeMap<>();
		initCoinKind(coin);
	}

	private void initCoinKind(List<Integer> coin) {
		coin.stream().map(Coin::fromMoney).forEach(c -> coinMap.put(c, 0));
	}

	public void addCoin(Coin coin) {
		coinMap.put(coin, coinMap.getOrDefault(coin, 0) + 1);
	}

	public String getMachineCoin() {
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

	public String subtract(int payMoney) {
		TreeMap<Coin, Integer> smallChange = new TreeMap<>(new CoinComparator());
		List<Coin> reverseSortedList = coinMap.keySet()
			.stream().collect(Collectors.toList());
		for (Coin coin : reverseSortedList) {
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
