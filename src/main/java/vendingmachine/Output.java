package vendingmachine;

import java.util.HashMap;

public class Output {
	final static String WON = "원";
	final static String COUNT = "개";
	final static String CHANGE = "잔돈";
	final static String INPUT_MONEY = "투입 금액: ";
	final static String VENDINGMACHINE_HAS_MONEY = "자판기가 보유한 동전";

	// 자판기가 보유한 잔돈 출력
	static void hasCoinPrint(HashMap<Coin, Integer> coinMap) {
		System.out.println(VENDINGMACHINE_HAS_MONEY);
		for (Coin money : Coin.values()) {
			System.out.println(money.getAmount() + WON + " - " + coinMap.get(money) + COUNT);
		}

	}// 현재 투입금액 상태 출력

	public static void inputMoneyPrint(int inputMoney) {
		System.out.print(INPUT_MONEY);
		System.out.println(inputMoney + WON);
	}

	// 거슬러주는 잔돈 출력
	public static void changesPrint(HashMap<Coin, Integer> coinMap) {
		System.out.println(CHANGE);
		for (Coin money : Coin.values()) {
			if (coinMap.get(money) > 0) {
				System.out.println(money.getAmount() + WON + " - " + coinMap.get(money) + COUNT);
			}
		}
	}
}
