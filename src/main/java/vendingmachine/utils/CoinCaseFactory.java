package vendingmachine.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.model.Coin;
import vendingmachine.model.CoinCase;
import vendingmachine.view.OutputView;

public class CoinCaseFactory {

	private static final int INITIAL_VALUE = 0;

	private CoinCaseFactory() {
	}

	public static CoinCase makeCoinCase(int totalAmount) {
		CoinCase coinCase = new CoinCase();
		int currentAmount = totalAmount;
		while (currentAmount > INITIAL_VALUE) {
			int pickedCoinAmount = pickRandomCoin(currentAmount);
			currentAmount -= pickedCoinAmount;
			increasePickedCoin(coinCase, pickedCoinAmount);
		}
		OutputView.printVendingMachineCoinStatus(coinCase);
		return coinCase;
	}

	private static void increasePickedCoin(CoinCase coinCase, int pickedCoin) {
		coinCase.increasePickedCoinCount(Coin.getCoinEqualAmount(pickedCoin));
	}

	private static int pickRandomCoin(int currentAmount) {
		int pickedCoinAmount;
		do {
			pickedCoinAmount = Randoms.pickNumberInList(makeRandomCoinRange());
		}
		while (currentAmount < pickedCoinAmount);
		return pickedCoinAmount;
	}

	private static List<Integer> makeRandomCoinRange() {
		return Arrays.stream(Coin.values())
			.map(Coin::getAmount)
			.collect(Collectors.toList());
	}
}
