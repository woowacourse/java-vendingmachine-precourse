package vendingmachine.utils;

import static vendingmachine.constants.Message.*;

import java.util.Map;

import vendingmachine.domain.Coin;

public class View {
	private View() {

	}

	public static void showCoins(Map<Coin, Integer> coins, String message) {
		System.out.println(message);
		coins.forEach(View::showCoin);
		System.out.println(ENTER_LINE);
	}

	private static void showCoin(Coin coinType, int count) {
		System.out.println(coinType.getAmount() + WON + SPACE + count + COUNT);
	}

	public static void showMoney(int money) {
		System.out.println(ANSWER_INPUT_COST + money + WON);
	}

	public static void showAskMessage(String askMessage) {
		System.out.println(askMessage);
	}

	public static void showErrorMessage(String errorMessage) {
		System.out.println(errorMessage);
	}
}
