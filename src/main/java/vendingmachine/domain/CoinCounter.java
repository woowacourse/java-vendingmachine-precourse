package vendingmachine.domain;

import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class CoinCounter {
	private SortedMap<Coin, Integer> counterMap;

	public CoinCounter() {
		counterMap = new TreeMap<>();
		Arrays.stream(Coin.values())
			.forEach(enumObj -> counterMap.put(enumObj, 0));
	}

	public void plusCount(Coin coin) {
		counterMap.put(coin, counterMap.get(coin) + 1);
	}

	public void minusCount(Coin coin) {
		counterMap.put(coin, counterMap.get(coin) - 1);
	}

	@Override
	public String toString() {
		return counterMap.keySet()
			.stream()
			.map(enumObjAsKey -> enumObjAsKey.toAmount() + "원 - " + counterMap.get(enumObjAsKey) + "개")
			.collect(Collectors.joining(System.lineSeparator()));
	}

	public String toReturnCoinString() {
		return counterMap.keySet()
			.stream()
			.filter(key -> counterMap.get(key) > 0)
			.map(enumObjAsKey -> enumObjAsKey.toAmount() + "원 - " + counterMap.get(enumObjAsKey) + "개")
			.collect(Collectors.joining(System.lineSeparator()));
	}

	public boolean isAnyAvailable() {
		return this.counterMap.keySet()
			.stream()
			.anyMatch(key -> counterMap.getOrDefault(key, 0) > 0);
	}

	public void forEach(BiConsumer<Coin, Integer> action) {
		this.counterMap.forEach(action);
	}
}
