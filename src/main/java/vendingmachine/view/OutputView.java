package vendingmachine.view;

import static vendingmachine.constant.Constant.*;
import static vendingmachine.constant.ViewMessage.*;

import java.util.Map;

import vendingmachine.model.Change;
import vendingmachine.model.PossessionCoin;

public class OutputView {

	public static void reportPossessionCoin(Map<Integer, Integer> possessionCoins) {
		System.out.println(ENTER + POSSESSION_COIN_REPORT_MESSAGE);
		for (Map.Entry<Integer, Integer> coin : possessionCoins.entrySet()) {
			reportCoins(coin.getKey(), coin.getValue());
		}
	}

	private static void reportCoins(int amount, int count) {
		System.out.println(amount + MONEY_UNIT + MONEY_COIN_SEPARATION + count + COIN_UNIT);
	}

	public static void reportInputMoney(int money) {
		System.out.println(ENTER + INPUT_MONEY_REPORT_MESSAGE + money + MONEY_UNIT);
	}

	public static void reportChangeCoin(Map<Integer, Integer> changeCoins) {
		System.out.println(CHANGE_REPORT_MESSAGE);
		for (Map.Entry<Integer, Integer> coin : changeCoins.entrySet()) {
			if (coin.getValue() != 0) {
				reportCoins(coin.getKey(), coin.getValue());
			}
		}
	}
}
