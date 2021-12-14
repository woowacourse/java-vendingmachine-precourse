package vendingmachine.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
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
		this.coinMap = merge(coinMap);
	}

	private Map<Coin, Quantity> createEmpty() {
		return new LinkedHashMap<>(
			Arrays.stream(Coin.values())
				.collect(LinkedHashMap::new,
					(map, coin) -> map.put(coin, Quantity.ZERO),
					Map::putAll)
		);
	}

	private Map<Coin, Quantity> merge(Map<Coin, Quantity> other) {
		other.forEach((k, v) -> this.coinMap.merge(k, v, Quantity::plus));
		return this.coinMap;
	}

	public ChangeSafe giveChange(Money money) {
		Map<Coin, Quantity> retCoinMap = new LinkedHashMap<>();
		while (money.isGreaterThan(Money.ZERO)) {
			Optional<Coin> optionalCoin = pickGreedy(money);
			if (!optionalCoin.isPresent()) {
				break;
			}
			Coin coin = optionalCoin.get();
			createOrAdd(retCoinMap, coin);
			money = money.minus(coin.toMoney());
			coinMap.put(coin, coinMap.get(coin).minus(Quantity.ONE));
		}
		return new ChangeSafe(retCoinMap);
	}

	private Optional<Coin> pickGreedy(Money money) {
		return Arrays.stream(Coin.values())
			.filter(coin -> !coin.toMoney().isGreaterThan(money) && coinMap.get(coin).isEnough())
			.findFirst();
	}

	private void createOrAdd(Map<Coin, Quantity> coins, Coin coin) {
		if (!coins.containsKey(coin)) {
			coins.put(coin, Quantity.ONE);
			return;
		}
		coins.put(coin, coins.get(coin).plus(Quantity.ONE));
	}

	@Override
	public String toString() {
		return coinMap.entrySet()
			.stream()
			.map(entry -> String.format(FORMAT, entry.getKey().toString(), entry.getValue().toString()))
			.collect(Collectors.joining(JOINER));
	}

}
