package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class Changes {
	private Map<Coin, Integer> changes = new LinkedHashMap<>();

	public Changes(int money) {
		initChangesMap(this.changes);
		makeRandomCoin(money);
	}

	public Changes(Map<Coin, Integer> changes) {
		this.changes = changes;
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

	private void initChangesMap(Map<Coin, Integer> changeMap) {
		changeMap.put(Coin.COIN_500, 0);
		changeMap.put(Coin.COIN_100, 0);
		changeMap.put(Coin.COIN_50, 0);
		changeMap.put(Coin.COIN_10, 0);
	}

	public Map<Coin, Integer> getChanges() {
		return changes;
	}

	public int getTotalAmount() {
		int totalAmount = 0;
		for (Map.Entry<Coin, Integer> changeEntry : changes.entrySet()) {
			totalAmount += changeEntry.getKey().getAmount() * changeEntry.getValue();
		}
		return totalAmount;
	}

	public Changes returnChange(int amount) {
		Map<Coin, Integer> changesToReturn = new LinkedHashMap<>();
		initChangesMap(changesToReturn);

		for (Map.Entry<Coin, Integer> changeEntry : changes.entrySet()) {
			Coin nowCoin = changeEntry.getKey();
			int nowCoinNum = changeEntry.getValue();
			int dividedNum = amount / nowCoin.getAmount();

			if (nowCoinNum == 0 && dividedNum <= 0) {
				continue;
			}

			if (dividedNum <= nowCoinNum) {
				// 만약 해당 단위의 동전으로만 줘도 될만큼 충분히 많을경우
				changesToReturn.replace(nowCoin, dividedNum);
				changes.replace(nowCoin, nowCoinNum - dividedNum);
				amount -= dividedNum * nowCoin.getAmount();
				continue;
			}
			changesToReturn.replace(nowCoin, nowCoinNum);
			amount -= nowCoinNum * nowCoin.getAmount();
			changes.put(nowCoin, 0);
		}

		return new Changes(changesToReturn);
	}
}
