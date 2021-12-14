package vendingmachine.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ChangeSafe {
	private static final String FORMAT = "%s - %s";
	private static final String JOINER = "\n";

	private Map<Coin, Quantity> coinMap;

	public ChangeSafe() {
		this.coinMap = Coin.createEmpty();
	}

	public ChangeSafe(Map<Coin, Quantity> coinMap) {
		this.coinMap = coinMap;
	}

	private Map<Coin, Quantity> merge(Map<Coin, Quantity> other) {
		other.forEach((k, v) -> this.coinMap.merge(k, v, Quantity::plus));
		return this.coinMap;
	}

	public boolean isEnough(Coin coin) {
		return coinMap.get(coin).isEnough();
	}

	public void decrease(Coin coin) {
		coinMap.put(coin, coinMap.get(coin).minus(Quantity.ONE));
	}

	@Override
	public String toString() {
		return coinMap.entrySet()
			.stream()
			.map(entry -> String.format(FORMAT, entry.getKey().toString(), entry.getValue().toString()))
			.collect(Collectors.joining(JOINER));
	}

}
