package vendingmachine.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.model.Coin;
import vendingmachine.model.UserMoney;

public class ResultView {

	public static void printRemains(List<Coin> coinList) {
		System.out.println(Messages.REMAINS_MESSAGE);
		for (Coin coin : coinList) {
			System.out.println(coin.getValue() + "원 - " + coin.getCount() + "개");
		}
	}

	public static void printChange(HashMap<Integer, Integer> change) {
		for (Map.Entry<Integer, Integer> entrySet : change.entrySet()) {
			System.out.println(entrySet.getKey() + "원 - " + entrySet.getValue() + "개");
		}
	}

	public static void printRemainMoney(UserMoney userMoney) {
		System.out.println("\n투입 금액: " + userMoney.getMoney() + "원\n" + "잔돈");
	}
}
