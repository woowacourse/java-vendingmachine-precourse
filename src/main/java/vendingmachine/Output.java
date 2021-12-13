package vendingmachine;

import java.util.HashMap;


public class Output {

	// 자판기가 보유한 잔돈 출력
	static void hasCoinPrint(HashMap<Coin, Integer> coinMap) {
		System.out.println("자판기가 보유한 동전");
		for (Coin money : Coin.values()) {
			System.out.println(money.getAmount() + "원 - " + coinMap.get(money) + "개");
		}

	}// 현재 투입금액 상태 출력

	public static void inputMoneyPrint(int inputMoney) {
		System.out.print("투입 금액: ");
		System.out.println(inputMoney + "원");
	}

	// 거슬러주는 잔돈 출력
	public static void changesPrint(HashMap<Coin, Integer> coinMap) {
		System.out.println("잔돈");
		for (Coin money : Coin.values()) {
			if (coinMap.get(money) > 0) {
				System.out.println(money.getAmount() + "원 - " + coinMap.get(money) + "개");
			}
		}
		// 배열을 풀어서 프린트하기

	}
}
