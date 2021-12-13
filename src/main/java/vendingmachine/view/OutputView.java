package vendingmachine.view;

import java.util.Arrays;
import java.util.Map;

import vendingmachine.model.Coin;
import vendingmachine.model.Wallet;

public class OutputView {

	public static void containCoins(Wallet wallet) {
		System.out.println("자판기가 보유한 동전");
		Arrays.stream(Coin.values())
			.forEach(coin -> System.out.println(coin.getAmount() + "원 - " + wallet.getWallet().get(coin) + "개"));
	}

	public static void remainCoins(Map<Coin, Integer> remain) {
	}

	public static void remainBalance(int balance) {
		System.out.println("투입 금액: " + balance + "원");
	}
}
