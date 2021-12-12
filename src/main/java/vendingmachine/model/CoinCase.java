package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import vendingmachine.utils.exception.MoneyException;

public class CoinCase {

	private final Coin coin;
	private int count;
	private int currentAmount;
	private static final int INITIAL_VALUE = 0;
	private static final int MINIMUM_RANGE = 1;

	public CoinCase(Coin coin, int currentAmount) {
		// 검증을 먼저 하면 가끔씩 currnetAmount에 0이 들어가서 에러 발생. 이유??
		// MoneyException.validateMoney(currentAmount);
		this.currentAmount = currentAmount;
		this.coin = coin;
		this.count = calculateCountOfCoin();
	}

	public Coin getCoin() {
		return coin;
	}

	public int getNumber() {
		return count;
	}

	public int getCurrentAmount() {
		currentAmount -= count * coin.getAmount();
		return currentAmount;
	}

	public int returnChange(int changeUserWant) {
		if (count < changeUserWant) {
			changeUserWant = count;
			count = INITIAL_VALUE;
			return changeUserWant;
		}
		count -= changeUserWant;
		return changeUserWant;
	}

	private int calculateCountOfCoin() {
		int maxCount = currentAmount / coin.getAmount();
		if (maxCount == INITIAL_VALUE) {
			return maxCount;
		}
		if (coin.getAmount() == Coin.COIN_10.getAmount()) {
			return maxCount;
		}
		return Randoms.pickNumberInList(makeRandomNumberRange(maxCount));
	}

	private List<Integer> makeRandomNumberRange(int maxCount) {
		List<Integer> randomCountRange = new ArrayList<>();
		randomCountRange.add(INITIAL_VALUE);
		for (int i = MINIMUM_RANGE; i <= maxCount; i++) {
			randomCountRange.add(i);
		}
		return randomCountRange;
	}
}
