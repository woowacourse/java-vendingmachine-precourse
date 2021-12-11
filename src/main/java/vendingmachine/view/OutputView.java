package vendingmachine.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Count;

public class OutputView {
	private static final String HOLDING_COINS_GUIDE_MESSEAGE = "자판기가 보유한 동전";
	private static final String HOLDING_COINS_CONNECTOR = "원 - ";
	private static final String HOLDING_COINS_GUIDE_MESSEAGE_SUFFIX = "개";
	private static final String INPUT_MONEY_GUIDE_MESSEAGE = "투입 금액: ";
	private static final String INPUT_MONEY_GUIDE_MESSEAGE_SUFFIX = "원";

	public static void printHoldingCoins(Map<Coin, Count> coins) {
		System.out.println();
		System.out.println(HOLDING_COINS_GUIDE_MESSEAGE);
		for (Coin coin : coins.keySet()) {
			System.out.print(coin.getAmount());
			System.out.print(HOLDING_COINS_CONNECTOR);
			System.out.print(coins.get(coin).getCount());
			System.out.println(HOLDING_COINS_GUIDE_MESSEAGE_SUFFIX);
		}
	}

	public static void printInputMoney(String inputMoney) {
		System.out.println(INPUT_MONEY_GUIDE_MESSEAGE);
		System.out.println(inputMoney);
		System.out.println(INPUT_MONEY_GUIDE_MESSEAGE_SUFFIX);
	}
}
