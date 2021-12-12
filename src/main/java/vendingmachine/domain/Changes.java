package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class Changes {
	private Map<Coin, Integer> changes = new LinkedHashMap<>();

	public Changes(int money) {
		initChangesMap();
		makeRandomCoin(money);
	}

	private void makeRandomCoin(int money) {
		List<Integer> coinCandidates = Coin.getCoinAmountList();
		while (money > 0) {
			int selectAmount = Randoms.pickNumberInList(coinCandidates);
			if (isMoneyUnderSelectAmount(money, selectAmount))
				continue;
			Coin coin = Coin.getCoinByAmount(selectAmount);
			changes.replace(coin, changes.get(coin) + 1);
			money -= selectAmount;
		}
	}

	private boolean isMoneyUnderSelectAmount(int money, int selectAmount) {
		return money < selectAmount;
	}

	private void initChangesMap() {
		changes.put(Coin.COIN_500, 0);
		changes.put(Coin.COIN_100, 0);
		changes.put(Coin.COIN_50, 0);
		changes.put(Coin.COIN_10, 0);
	}

	public Map<Coin, Integer> getChanges() {
		return changes;
	}
}
