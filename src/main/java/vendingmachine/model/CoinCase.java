package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CoinCase {

	private final Coin coin;
	private final int number;
	private int vendingMachineAmount;
	private static final int INITIAL_VALUE = 0;
	private static final int MINIMUM_RANGE = 1;

	public CoinCase(Coin coin, int vendingMachineAmount) {
		this.coin = coin;
		this.vendingMachineAmount = vendingMachineAmount;
		this.number = calculateNumberOfCoin();
	}

	public Coin getCoin() {
		return coin;
	}

	public int getNumber() {
		return number;
	}

	public int getVendingMachineAmount() {
		vendingMachineAmount -= number * coin.getAmount();
		return vendingMachineAmount;
	}

	private int calculateNumberOfCoin() {
		int maxNumber = vendingMachineAmount / coin.getAmount();
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
