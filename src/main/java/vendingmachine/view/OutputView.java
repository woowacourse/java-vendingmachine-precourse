package vendingmachine.view;

import java.util.Set;

import vendingmachine.model.Coin;
import vendingmachine.model.Coins;
import vendingmachine.util.Constant;

public class OutputView {
	public static Coins coins;
	public static Coins changeCoins;

	public static void showHoldingCoins(int input) {
		coins = new Coins();
		System.out.println();
		System.out.println(Constant.SHOW_HOLDING_COINS);
		coins.generate(input);
		coins.showAll();
	}

	public static void showInputAmount(int inputAmount) {
		System.out.println(Constant.SHOW_INPUT_AMOUNT + inputAmount + "원");
	}

	public static void showChanges(int inputAmount) {
		System.out.println();
		System.out.println(Constant.SHOW_CHANGES);
		getChanges(inputAmount);
		changeCoins.showExists();
	}

	private static void getChanges(int inputAmount) {
		changeCoins = new Coins();
		for (Coin coin : coins.keySet()) {
			int count = Math.min(inputAmount / coin.getAmount(), coins.getAmount(coin));
			changeCoins.replace(coin, count);
			inputAmount -= coin.getAmount() * count;
		}
	}
}
