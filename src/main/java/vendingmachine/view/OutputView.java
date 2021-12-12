package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.Coins;

public class OutputView {
	private static final String NOTICE_INIT_LEFT_COINS = "자판기가 보유한 동전";
	private static final String NOTICE_CHANGES = "잔돈";

	public static void showInitialLeftCoins(Coins leftCoins) {
		// TODO: 동전 출력 순서(map order)
		System.out.println(NOTICE_INIT_LEFT_COINS);
		Map<Coin, Integer> leftCoinMap = leftCoins.getCoins();
		for (Coin coin : leftCoinMap.keySet()) {
			System.out.println(coin.getAmount() + "원" + " - " + leftCoinMap.get(coin) + "개");
		}
	}

	public static void showChanges(Coins changes) {
		System.out.println(NOTICE_CHANGES);
		Map<Coin, Integer> changesCoinsMap = changes.getCoins();
		for (Coin coin : changesCoinsMap.keySet()) {
			if (changesCoinsMap.get(coin) > 0) {
				System.out.println(coin.getAmount() + "원" + " - " + changesCoinsMap.get(coin) + "개");
			}
		}
	}
}
