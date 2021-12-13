package vendingmachine.view;

import static vendingmachine.constant.ViewMessage.*;

import java.util.Arrays;
import java.util.Map;

import vendingmachine.model.Coin;
import vendingmachine.model.Wallet;

public class OutputView {

	public static void containCoins(Wallet wallet) {
		System.out.println(OWN_COIN);
		Arrays.stream(Coin.values())
			.forEach(coin -> printMoney(coin.getAmount(), wallet.getWallet().get(coin)));
	}

	public static void remainCoins(Map<Coin, Integer> remain) {
		System.out.println(CHANGE);
		for (Map.Entry<Coin, Integer> entry : remain.entrySet()) {
			if (entry.getValue() == 0) {
				continue;
			}
			printMoney(entry.getKey().getAmount(), entry.getValue());
		}
	}

	private static void printMoney(int amount, int count) {
		System.out.println(amount + "원 - " + count + "개");
	}

	public static void remainBalance(int balance) {
		System.out.println("투입 금액: " + balance + "원");
	}
}
