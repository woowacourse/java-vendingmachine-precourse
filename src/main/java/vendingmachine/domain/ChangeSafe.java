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
		this.coinMap = createEmpty();
	}

	public ChangeSafe(Map<Coin, Quantity> coinMap) {
		this();
		merge(coinMap);
	}

	private Map<Coin, Quantity> createEmpty() {
		return new LinkedHashMap<>(
			Arrays.stream(Coin.values())
				.collect(LinkedHashMap::new,
					(map, coin) -> map.put(coin, Quantity.ZERO),
					Map::putAll)
		);
	}

	public ChangeSafe merge(ChangeSafe other) {
		return new ChangeSafe(other.coinMap);
	}

	private void merge(Map<Coin, Quantity> other) {
		other.forEach((k, v) -> this.coinMap.merge(k, v, Quantity::plus));
	}

	@Override
	public String toString() {
		return coinMap.entrySet()
			.stream()
			.map(entry -> String.format(FORMAT, entry.getKey().toString(), entry.getValue().toString()))
			.collect(Collectors.joining(JOINER));
	}
}
