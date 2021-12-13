package vendingmachine.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ChangeSafe {
	private static final int INIT_QUANTITY = 0;
	private static final String FORMAT = "%s - %s";
	private static final String JOINER = "\n";

	private Map<Coin, Quantity> coinMap;

	public ChangeSafe() {
		this.coinMap = createEmpty();
	}

	public ChangeSafe(Map<Coin, Quantity> coinMap) {
		this.coinMap = new LinkedHashMap<>(coinMap);
	}

	private Map<Coin, Quantity> createEmpty() {
		return new LinkedHashMap<>(
			Arrays.stream(Coin.values()).collect(Collectors.toMap(coin -> coin, coin -> Quantity.ZERO))
		);
	}

	public ChangeSafe merge(ChangeSafe other) {
		other.coinMap.forEach((k, v) -> this.coinMap.merge(k, v, Quantity::plus));
		return new ChangeSafe(this.coinMap);
	}

	@Override
	public String toString() {
		return coinMap.entrySet()
			.stream()
			.map(entry -> String.format(FORMAT, entry.getKey().toString(), entry.getValue().toString()))
			.collect(Collectors.joining(JOINER));
	}
}
