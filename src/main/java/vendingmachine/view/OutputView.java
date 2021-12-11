package vendingmachine.view;

import static vendingmachine.constant.ViewMessage.*;

import java.util.Map;

import vendingmachine.model.PossessionCoin;

public class OutputView {

	public static void reportPossessionCoin(PossessionCoin possessionCoin) {
		System.out.println();
		System.out.println(POSSESSION_COIN_REPORT_MESSAGE);
		reportCoins(possessionCoin.getCoins());
	}

	private static void reportCoins(Map<Integer, Integer> coins) {
		for (Map.Entry<Integer, Integer> coin : coins.entrySet()) {
			System.out.println(coin.getKey() + MONEY_UNIT + MONEY_COIN_SEPARATION + coin.getValue() + COIN_UNIT);
		}
	}
}
