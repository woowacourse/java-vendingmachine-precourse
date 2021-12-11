package vendingmachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultView {
	private static final String REMAINS_MESSAGE = "\n자판기가 보유한 동전";

	public static void printRemains(List<Coin> coinList) {
		System.out.println(REMAINS_MESSAGE);
		for (Coin coin : coinList) {
			System.out.println(coin.getValue() + "원 - " + coin.getCount() + "개");
		}
	}

	public static void printChange(UserMoney userMoney, HashMap<Integer, Integer> change) {
		System.out.println("\n투입 금액: " + userMoney.getMoney() + "원\n" + "잔돈");
		for (Map.Entry<Integer, Integer> entrySet : change.entrySet()) {
			System.out.println(entrySet.getKey() + "원 - " + entrySet.getValue() + "개");
		}
	}
}
