package vendingmachine.model;

import java.util.List;

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

	public List<Integer> getNumberOfCoins(){
		return coinStorage.getNumberOfCoins();
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
