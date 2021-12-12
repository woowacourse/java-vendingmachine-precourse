package vendingmachine.view;

import vendingmachine.domain.coin.Coins;

public class OutputView {
	private static final String NOTICE_INIT_LEFT_COINS = "자판기가 보유한 동전";
	private static final String NOTICE_CHANGES = "잔돈";

	public static void showInitialLeftCoins(Coins leftCoins) {
		System.out.println();
		System.out.println(NOTICE_INIT_LEFT_COINS);
		System.out.println(leftCoins);
	}

	public static void showChanges(Coins changes) {
		System.out.println(NOTICE_CHANGES);
		System.out.println(changes);
	}
}
