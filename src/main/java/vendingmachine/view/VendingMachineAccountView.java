package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Coin;

public class VendingMachineAccountView {
	private static final String INPUT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String COIN_LIST_FORMAT = "%d원 - %d개";

	public static void printInputGuide() {
		System.out.println(INPUT_MESSAGE);
	}

	public static void printCoinMap(Map<Coin, Integer> coinMap) {
		for (Coin coin : coinMap.keySet()) {
			System.out.println(String.format(COIN_LIST_FORMAT, coin.getAmount(), coinMap.get(coin)));
		}
		System.out.println();
	}
}
