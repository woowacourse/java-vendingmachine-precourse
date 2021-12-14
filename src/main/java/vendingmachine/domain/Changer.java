package vendingmachine.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Changer {
	private final Changes havingChanges;
	private final Changes returningChanges;
	private int remainAmount;

	public Changer(Changes havingChanges, int remainAmount) {
		this.havingChanges = havingChanges;
		this.returningChanges = new Changes();
		this.remainAmount = remainAmount;
	}

	public Changes returnChange() {
		for (Coin nowCoin : getHavingCoins()) {
			int dividedNum = nowCoin.getNumDivided(remainAmount);
			int nowCoinNum = havingChanges.getCoinNum(nowCoin);
			if (isZero(dividedNum)) {
				continue;
			}
			if (isDividedNumMoreThanHavingCoinNum(nowCoinNum, dividedNum)) {
				doReturnChanges(nowCoin, dividedNum);
			}
			doReturnChanges(nowCoin, nowCoinNum);
		}
		return returningChanges;
	}

	private boolean isDividedNumMoreThanHavingCoinNum(int nowCoinNum, int dividedNum) {
		return dividedNum <= nowCoinNum;
	}

	private boolean isZero(int dividedNum) {
		return dividedNum == 0;
	}

	private void doReturnChanges(Coin nowCoin, int coinNum) {
		havingChanges.minusCoin(nowCoin, coinNum);
		returningChanges.addCoin(nowCoin, coinNum);
		remainAmount -= nowCoin.getValue(coinNum);
	}

	private List<Coin> getHavingCoins() {
		return havingChanges
			.getChangesMap().entrySet()
			.stream().filter(e -> e.getValue() > 0)
			.map(Map.Entry::getKey).collect(Collectors.toList());
	}
}
