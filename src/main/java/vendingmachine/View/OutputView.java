package vendingmachine.View;

import java.util.LinkedHashMap;

import vendingmachine.Model.Coin;
import vendingmachine.Model.CoinWallet;

public class OutputView {
	public static final String PRINT_COIN_SETTING = "%s원 - %d개%n";
	public static final String PRINT_USER_MONEY_SETTING = "투입 금액: %d원%n";
	public static final String PRINT_MACHINE_COIN = "자판기가 보유한 동전";
	public static final String PRINT_CHANGE = "잔돈";

	public static void printCoin(LinkedHashMap<Coin, Integer> coins) {
		System.out.println(PRINT_MACHINE_COIN);
		for (Coin coin : coins.keySet()) {
			System.out.printf(PRINT_COIN_SETTING, coin.getAmount(), coins.get(coin));
		}
	}

	public static void printUserMoney(int money) {
		System.out.printf(PRINT_USER_MONEY_SETTING, money);
	}

	public static void printEmpty() {
		System.out.println();
	}

	public static void printChange(CoinWallet coinWallet) {
		System.out.println(PRINT_CHANGE);
		coinWallet.coins
			.keySet()
			.stream()
			.filter(coin -> coinWallet.getNum(coin) != 0)
			.forEach(coin -> System.out.printf(PRINT_COIN_SETTING, coin.getAmount(), coinWallet.getNum(coin)));
	}
}
