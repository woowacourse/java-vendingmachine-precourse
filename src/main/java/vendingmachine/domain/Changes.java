package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class Changes {
	private final Map<Coin, Integer> changes = new LinkedHashMap<>();

	public Changes() {
		initChangesMap(this.changes);
	}

	public void makeRandomCoin(int money) {
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

	private void initChangesMap(Map<Coin, Integer> changeMap) {
		changeMap.put(Coin.COIN_500, 0);
		changeMap.put(Coin.COIN_100, 0);
		changeMap.put(Coin.COIN_50, 0);
		changeMap.put(Coin.COIN_10, 0);
	}

	public Map<Coin, Integer> getChangesMap() {
		return changes;
	}

	public int getTotalAmount() {
		int totalAmount = 0;
		for (Map.Entry<Coin, Integer> changeEntry : changes.entrySet()) {
			totalAmount += changeEntry.getKey().getAmount() * changeEntry.getValue();
		}
		return totalAmount;
	}

	public int getCoinNum(Coin coin) {
		return changes.get(coin);
	}

	public void minusCoin(Coin coin, int returnNum) {
		changes.replace(coin, changes.get(coin) - returnNum);
	}

	public void addCoin(Coin coin, int addedNum) {
		changes.replace(coin, changes.get(coin) + addedNum);
	}

	public Changes returnChange(int amount) {
		Changer changer = new Changer(this, amount);
		return changer.returnChange();
	}
}
