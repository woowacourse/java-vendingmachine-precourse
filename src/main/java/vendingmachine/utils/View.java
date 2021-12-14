package vendingmachine.utils;

import static vendingmachine.constants.Message.*;
import static vendingmachine.utils.Print.*;

import java.util.Map;

import vendingmachine.domain.Coin;

public class View {
	private View() {

	}

	public static void showCoins(Map<Coin, Integer> coins, String message) {
		showMessage(message);
		coins.forEach(View::showCoin);
		showMessage(ENTER_LINE);
	}

	private static void showCoin(Coin coinType, int count) {
		showMessage(coinType.getAmount() + WON + SPACE + count + COUNT);
	}

	public static void showMoney(int money) {
		showMessage(ANSWER_INPUT_COST + money + WON);
	}

	public static void showAskMessage(String askMessage) {
		showMessage(askMessage);
	}

	public static void showErrorMessage(String errorMessage) {
		showMessage(errorMessage);
	}
}
