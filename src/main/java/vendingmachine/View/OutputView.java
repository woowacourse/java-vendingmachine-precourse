package vendingmachine.View;

import java.util.LinkedHashMap;

import vendingmachine.Constants;
import vendingmachine.Model.Coin;
import vendingmachine.Model.CoinWallet;

public class OutputView {
	public static void printCoin(LinkedHashMap<Coin, Integer> coins) {
		System.out.println(Constants.PRINT_MACHINE_COIN);
		for (Coin coin : coins.keySet()) {
			System.out.printf(Constants.PRINT_COIN_SETTING, coin.getAmount(), coins.get(coin));
		}
		System.out.println();
	}

	public static void printUserMoney(int money) {
		System.out.printf(Constants.PRINT_USER_MONEY_SETTING, money);
	}

	public static void printEmpty() {
		System.out.println();
	}

	public static void printChange(CoinWallet coinWallet) {
		System.out.println(Constants.PRINT_CHANGE);
		coinWallet.coins
			.keySet()
			.stream()
			.filter(coin -> coinWallet.getNum(coin) != 0)
			.forEach(coin -> System.out.printf(Constants.PRINT_COIN_SETTING, coin.getAmount(), coinWallet.getNum(coin)));
	}
}
