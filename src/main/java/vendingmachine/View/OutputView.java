package vendingmachine.View;

import java.util.LinkedHashMap;

import vendingmachine.Model.Coin;

public class OutputView {
	public static void printCoin(LinkedHashMap<Coin, Integer> coins) {
		System.out.println("자판기가 보유한 동전");
		for (Coin coin : coins.keySet()) {
			System.out.printf("%s원 - %d개%n", coin.getAmount(), coins.get(coin));
		}
	}

	public static void printUserMoney(int money) {
		System.out.printf("투입 금액: %d원", money);
	}
}
