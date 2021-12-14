package vendingmachine.view;

import static vendingmachine.constant.OutputMessage.*;

import vendingmachine.domain.coin.CoinCounter;
import vendingmachine.domain.user.User;

public class OutputView {
	public static void printCoinCounter(CoinCounter coinCounter) {
		System.out.println(COINS_HELD_BY_VENDING_MACHINE);
		System.out.println(coinCounter);
	}

	public static void printUserAmount(User user) {
		System.out.println();
		System.out.println(user);
	}

	public static void printChangeCoins(CoinCounter coinCounter) {
		System.out.println(CHANGE);
		System.out.println(coinCounter);
	}
}
