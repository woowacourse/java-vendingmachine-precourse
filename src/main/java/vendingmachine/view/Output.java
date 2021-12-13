package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;

public class Output {
	public static void coinsInMachine(Coins coins) {
		System.out.println("자판기가 보유한 동전");
		System.out.println(coins);
	}

	public static void inputMoney(int inputMoney) {
		System.out.println("\n투입 금액: " + inputMoney + "원");
	}

	public static void change(Map<Coin, Integer> change){
		System.out.println("잔돈");
		change.entrySet()
			.stream()
			.filter((entry) -> entry.getValue() > 0)
			.forEach((entry) -> System.out.println(entry.getKey() + " - " + entry.getValue() + "개"));
	}
}
