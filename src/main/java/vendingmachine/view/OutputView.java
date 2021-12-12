package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Changes;
import vendingmachine.domain.Coin;

public class OutputView {
	public static void printInitMessage() {
		System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
	}

	public static void printErrorMessage(String errorMessage) {
		System.out.println(errorMessage);
	}

	public static void printChanges(Changes changes) {
		Map<Coin, Integer> changesMap = changes.getChanges();
		System.out.println("자판기가 보유한 동전");
		printChangeStatus(changesMap);
	}

	private static void printChangeStatus(Map<Coin, Integer> changesMap) {
		for (Coin coin : changesMap.keySet()) {
			System.out.println(coin + " - " + changesMap.get(coin) + "개");
		}
	}

}
