package vendingmachine.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.resource.Coin;
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
			List<Integer> possibleMonetaryUnit = getPossibleMonetaryUnit(amount);
			int pickedAmount = Randoms.pickNumberInList(possibleMonetaryUnit);
			coinStorage.createCoin(pickedAmount);
			amount -= pickedAmount;
		}
	}

	public Map<Integer, Integer> getNumberOfCoins() {
		return makeMap(Coin.getMonetaryUnitList(), coinStorage.getNumberOfCoins());
	}

	public Map<Integer, Integer> getMinimumNumberCoins(int remainingMoney) {
		Map<Integer, Integer> numberOfMonetaryUnit = makeMap(Coin.getMonetaryUnitList(),
			coinStorage.getNumberOfCoins());
		Map<Integer, Integer> change = makeMap(Coin.getMonetaryUnitList(), new ArrayList<>(Arrays.asList(0, 0, 0, 0)));
		for (int monetaryUnit : numberOfMonetaryUnit.keySet()) {
			if (remainingMoney < monetaryUnit || numberOfMonetaryUnit.get(monetaryUnit) <= 0) {
				continue;
			}
			remainingMoney -= monetaryUnit;
			numberOfMonetaryUnit.put(monetaryUnit, numberOfMonetaryUnit.get(monetaryUnit) - 1);
			change.put(monetaryUnit, change.get(monetaryUnit) + 1);
		}
		return change;
	}

	private Map<Integer, Integer> makeMap(List<Integer> monetaryUnitList, List<Integer> numberOfCoins) {
		Map<Integer, Integer> numberOfMonetaryUnit = new HashMap<>();
		for (int i = 0; i < coinStorage.getNumberOfMonetaryUnitType(); i++) {
			numberOfMonetaryUnit.put(monetaryUnitList.get(i), numberOfCoins.get(i));
		}
		return numberOfMonetaryUnit;
	}

	private List<Integer> getPossibleMonetaryUnit(int amount) {
		List<Integer> monetaryUnit = Coin.getMonetaryUnitList();
		for (int oneUnit : Coin.getMonetaryUnitList()) {
			if (amount < oneUnit) {
				monetaryUnit.remove(0);
			}
		}
		return monetaryUnit;
	}
}
