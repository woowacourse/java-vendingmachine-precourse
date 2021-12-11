package vendingmachine.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.resource.CoinStorage;

public class CoinModel {
	private final static CoinModel coinModel = new CoinModel();

	private final CoinStorage coinStorage;

	private CoinModel() {
		coinStorage = CoinStorage.getCoinStorage();
	}

	public static CoinModel getCoinModel() {
		return coinModel;
	}

	public void generateCoins(String stringAmount) {
		int amount = Integer.parseInt(stringAmount);
		while (amount > 0) {
			List<Integer> possibleCoinType = getPossibleCoinType(amount);
			int pickedAmount = Randoms.pickNumberInList(possibleCoinType);
			coinStorage.createCoin(pickedAmount);
			amount -= pickedAmount;
		}
	}

	public Map<Integer, Integer> getNumberOfCoins() {
		return makeCoinTypeMap(coinStorage.getNumberOfCoins());
	}

	public Map<Integer, Integer> getMinimumNumberCoins(int remainingMoney) {
		Map<Integer, Integer> numberOfEachCoin = makeCoinTypeMap(coinStorage.getNumberOfCoins());
		Map<Integer, Integer> change = makeCoinTypeMap(new ArrayList<>(Arrays.asList(0, 0, 0, 0)));
		for (int coinType : numberOfEachCoin.keySet()) {
			remainingMoney = makeChangeForEachCoin(remainingMoney, numberOfEachCoin, change, coinType);
		}
		return change;
	}

	private int makeChangeForEachCoin(int remainingMoney, Map<Integer, Integer> numberOfEachCoin,
			Map<Integer, Integer> change, int coinType) {
		if (remainingMoney <= coinType * numberOfEachCoin.get(coinType)) {
			change.put(coinType, remainingMoney / coinType);
			remainingMoney %= coinType;
			return remainingMoney;
		}
		change.put(coinType, numberOfEachCoin.get(coinType));
		remainingMoney -= coinType * numberOfEachCoin.get(coinType);
		return remainingMoney;
	}

	private Map<Integer, Integer> makeCoinTypeMap(List<Integer> numberOfCoins) {
		Map<Integer, Integer> numberOfEachCoin = new LinkedHashMap<>();
		for (int i = 0; i < coinStorage.getNumberOfCoinType(); i++) {
			numberOfEachCoin.put(CoinStorage.COIN_TYPES_LIST.get(i), numberOfCoins.get(i));
		}
		return numberOfEachCoin;
	}

	private List<Integer> getPossibleCoinType(int amount) {
		return CoinStorage.COIN_TYPES_LIST.stream()
				.filter(CoinType -> amount >= CoinType)
				.collect(Collectors.toList());
	}
}
