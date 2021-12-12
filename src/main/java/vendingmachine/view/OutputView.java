package vendingmachine.view;

import static vendingmachine.constant.OutputMessage.*;

import vendingmachine.domain.CoinCounter;

public class OutputView {
	public static void printCoinCounter(CoinCounter coinCounter) {
		System.out.println(COINS_HELD_BY_VENDING_MACHINE);
		System.out.println(coinCounter);
	}
}
