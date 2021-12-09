package vendingmachine.coin;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomCoinGenerator implements CoinGenerator {
	private final List<Coin> coinList;

	public RandomCoinGenerator() {
		this.coinList = Arrays.asList(Coin.values());
	}


	@Override
	public Map<Coin, Integer> generate(int amount) {
		Map<Coin, Integer> coins = new EnumMap<>(Coin.class);
		while(amount != 0) {
			int index = Randoms.pickNumberInList(getOrdinals());
			Coin coin = coinList.get(index);
			coins.put(coin, coins.getOrDefault(coin,0)+1);
			amount -= coin.getAmount();
		}
		return coins;
	}

	private List<Integer> getOrdinals() {
		return coinList.stream()
			.map(Enum::ordinal)
			.collect(Collectors.toList());
	}

}
