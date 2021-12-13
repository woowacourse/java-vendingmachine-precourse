package vendingmachine.domain;

import static vendingmachine.resource.MessageResource.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Changes {
	private final Map<Coin, Integer> coinMap;

	public Changes(String inputAmount) {
		this.coinMap = createCoinMap(inputAmount);
	}

	public Map<Coin, Integer> createCoinMap(String inputAmount) {
		Map<Coin, Integer> copyCoinMap = initZeroCoinMap();
		List<Integer> coinList = Coin.getCoinList();
		int totalAmount = checkAmount(inputAmount);

		while (totalAmount > 0) {
			int randomCoin = Randoms.pickNumberInList(coinList);
			if (totalAmount - randomCoin >= 0) {
				totalAmount -= randomCoin;
				copyCoinMap.put(Coin.getCoinType(randomCoin),
					copyCoinMap.getOrDefault(Coin.getCoinType(randomCoin), 0) + 1);
			}
		}

		return copyCoinMap;
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

	private Map<Coin, Integer> initZeroCoinMap() {
		Map<Coin, Integer> zeroCoinMap = new HashMap<>();

		for (Integer coin : Coin.getCoinList()) {
			zeroCoinMap.put(Coin.getCoinType(coin), 0);
		}

		return zeroCoinMap;
	}

	private boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

	private int checkAmount(String totalAmount) {
		if (!isNumeric(totalAmount)) {
			throw new IllegalArgumentException(ERROR_AMOUNT_IS_NOT_NUMERIC);
		}
		if (Integer.parseInt(totalAmount) < 0) {
			throw new IllegalArgumentException(ERROR_AMOUNT_IS_NOT_POSITIVE_INT);
		}

		return Integer.parseInt(totalAmount);
	}
}
