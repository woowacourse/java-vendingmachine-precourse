package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CoinCase {

	private final Coin coin;
	private final int number;
	private int vendingMachineAmount;

	public CoinCase(Coin coin, int vendingMachineAmount) {
		this.coin = coin;
		this.vendingMachineAmount = vendingMachineAmount;
		this.number = calculateNumberOfCoin();
	}

	public int getVendingMachineAmount() {
		vendingMachineAmount -= number * coin.getAmount();
		return vendingMachineAmount;
	}

	private int calculateNumberOfCoin() {
		int maxNumber = vendingMachineAmount / coin.getAmount();
		if (vendingMachineAmount < coin.getAmount()) {
			return maxNumber;
		}
		int numberOfCoin = Randoms.pickNumberInList(makeRandomNumberRange(maxNumber));
		if (coin.getAmount() == Coin.COIN_10.getAmount()) {
			numberOfCoin = maxNumber;
		}
		return numberOfCoin;
	}

	private List<Integer> makeRandomNumberRange(int maxNumber) {
		List<Integer> randomNumberRange = new ArrayList<>();
		randomNumberRange.add(0);
		for (int i = 1; i <= maxNumber; i++) {
			randomNumberRange.add(i);
		}
		return randomNumberRange;
	}
}
