package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import vendingmachine.utils.ExceptionUtils;

public class CoinCase {

	private final Coin coin;
	private final int number;
	private int currentAmount;
	private static final int INITIAL_VALUE = 0;
	private static final int MINIMUM_RANGE = 1;

	public CoinCase(Coin coin, int currentAmount) {
		ExceptionUtils.validateMoney(currentAmount);
		this.coin = coin;
		this.currentAmount = currentAmount;
		this.number = calculateNumberOfCoin();
	}

	public Coin getCoin() {
		return coin;
	}

	public int getNumber() {
		return number;
	}

	public int getCurrentAmount() {
		currentAmount -= number * coin.getAmount();
		return currentAmount;
	}

	private int calculateNumberOfCoin() {
		int maxNumber = currentAmount / coin.getAmount();
		if (maxNumber == INITIAL_VALUE) {
			return maxNumber;
		}
		if (coin.getAmount() == Coin.COIN_10.getAmount()) {
			return maxNumber;
		}
		return Randoms.pickNumberInList(makeRandomNumberRange(maxNumber));
	}

	private List<Integer> makeRandomNumberRange(int maxNumber) {
		List<Integer> randomNumberRange = new ArrayList<>();
		randomNumberRange.add(INITIAL_VALUE);
		for (int i = MINIMUM_RANGE; i <= maxNumber; i++) {
			randomNumberRange.add(i);
		}
		return randomNumberRange;
	}
}