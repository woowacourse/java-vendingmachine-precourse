package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;

public class OutputView {
	private static final String NOTICE_INIT_LEFT_COINS = "자판기가 보유한 동전";

	public static void showInitialLeftCoins(Coins leftCoins) {
		// TODO: 동전 출력 순서(map order)
		System.out.println(NOTICE_INIT_LEFT_COINS);
		Map<Coin, Integer> leftCoinMap = leftCoins.getCoins();
		for (Coin coin : leftCoinMap.keySet()) {
			System.out.println(coin.getAmount() + "원" + " - " + leftCoinMap.get(coin) + "개");
		}
	}
}
