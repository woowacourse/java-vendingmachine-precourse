package vendingmachine.domain;

import static vendingmachine.resource.MessageResource.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.utils.NumericUtils;

public class Changes {
	private static final int DIVIDE_NUM = 10;

	private final Map<Coin, Integer> coinMap;

	public Changes(String inputAmount) {
		this.coinMap = createCoinMap(inputAmount);
	}

	public Map<Coin, Integer> createCoinMap(String inputAmount) {
		Map<Coin, Integer> copyCoinMap = initZeroCoinMap();
		List<Integer> coinList = Coin.getCoinList();
		int totalAmount = NumericUtils.parsePositiveInt(inputAmount);

		checkAmount(totalAmount);
		getRandomCoins(copyCoinMap, coinList, totalAmount);

		return copyCoinMap;
	}

	private void getRandomCoins(Map<Coin, Integer> copyCoinMap, List<Integer> coinList, int totalAmount) {
		while (totalAmount > 0) {
			int randomCoin = Randoms.pickNumberInList(coinList);
			if (totalAmount - randomCoin >= 0) {
				totalAmount -= randomCoin;
				addMap(copyCoinMap, randomCoin);
			}
		}
	}

	private void checkAmount(int totalAmount) {
		if (totalAmount % DIVIDE_NUM != 0) {
			throw new IllegalArgumentException(ERROR_IS_NOT_COIN_TYPE_EXIST);
		}
	}

	private void addMap(Map<Coin, Integer> copyCoinMap, int randomCoin) {
		copyCoinMap.put(Coin.getCoinType(randomCoin),
			copyCoinMap.getOrDefault(Coin.getCoinType(randomCoin), 0) + 1);
	}

	public int getCoinMapValue(Coin coin) {
		return this.coinMap.get(coin);
	}

	public List<Coin> orderByCoin() {
		return coinMap.keySet()
			.stream()
			.sorted()
			.collect(Collectors.toList());
	}

	public List<Coin> giveChanges(int currentAmount) {
		List<Coin> result = new ArrayList<>();

		for (Coin coin : changeCoinList()) {
			if (currentAmount >= coin.getAmount()) {
				currentAmount -= coin.getAmount();
				result.add(coin);
			}
		}

		return result;
	}

	public List<Coin> changeCoinList() {
		List<Coin> coinList = new ArrayList<>();

		for (Coin coin : coinMap.keySet()) {
			if (coinMap.get(coin) == 0) {
				continue;
			}
			int i = 0;
			while (coinMap.get(coin) != i++) {
				coinList.add(coin);
			}
		}

		return getOrderCoinList(coinList);
	}

	private Map<Coin, Integer> initZeroCoinMap() {
		Map<Coin, Integer> zeroCoinMap = new HashMap<>();

		for (Integer coin : Coin.getCoinList()) {
			zeroCoinMap.put(Coin.getCoinType(coin), 0);
		}

		return zeroCoinMap;
	}

	private List<Coin> getOrderCoinList(List<Coin> coinList) {
		return coinList.stream()
			.sorted(Comparator.comparingInt(Coin::getAmount).reversed())
			.collect(Collectors.toList());
	}
}
