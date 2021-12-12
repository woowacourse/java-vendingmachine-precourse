package vendingmachine.view;

import static vendingmachine.constant.Constant.*;
import static vendingmachine.constant.ViewMessage.*;

import java.util.Map;

import vendingmachine.model.Change;
import vendingmachine.model.PossessionCoin;

public class OutputView {

	public static void reportPossessionCoin(PossessionCoin possessionCoin) {
		System.out.println(ENTER + POSSESSION_COIN_REPORT_MESSAGE);
		reportCoins(possessionCoin.getCoins());
	}

	private static void reportCoins(Map<Integer, Integer> coins) {
		for (Map.Entry<Integer, Integer> coin : coins.entrySet()) {
			System.out.println(coin.getKey() + MONEY_UNIT + MONEY_COIN_SEPARATION + coin.getValue() + COIN_UNIT);
		}
	}

	public static void reportInputMoney(int money) {
		System.out.println(ENTER + INPUT_MONEY_REPORT_MESSAGE + money + MONEY_UNIT);
	}
}
