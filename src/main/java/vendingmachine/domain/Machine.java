package vendingmachine.domain;

import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class Machine {
	private HashMap<Integer, Integer> coinCount = new HashMap<>();

	public void setCoins(int changes) {
		while (changes != 0) {
			int pick = Randoms.pickNumberInList(Coin.getCoinList());
			if (changes - pick < 0) {
				continue;
			}
			addCoin(pick);
			changes -= pick;
		}
	}

	private void addCoin(int pick) {
		if (coinCount.containsKey(pick)) {
			coinCount.put(pick, coinCount.get(pick) + 1);
			return;
		}
		coinCount.put(pick, 1);
	}

	public HashMap<Integer, Integer> getCoinCount() {
		return coinCount;
	}
}
