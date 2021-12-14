package vendingmachine.view;

import java.util.Map;

import camp.nextstep.edu.missionutils.Console;

public class MachineView {
	private static final String INPUT_INITIAL_COINS_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String INPUT_MERCHANDISE_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String INPUT_PAYMENT_MESSAGE = "투입 금액을 입력해 주세요.";
	private static final String INPUT_BUY_MESSAGE = "구매할 상품명을 입력해 주세요.";
	private static final String CHANGES_MESSAGE = "잔돈";
	private static final String OUTPUT_COINS_MESSAGE = "자판기가 보유한 동전";
	private static final String OUTPUT_COINS_INFO = "%d원 - %d개\n";
	private static final String OUTPUT_BALANCE = "투입 금액: %d원\n";

	public String inputInitialCoins() {
		System.out.println(INPUT_INITIAL_COINS_MESSAGE);
		return Console.readLine();
	}

	public void printInitialCoins(Map<Integer, Integer> coins) {
		System.out.println();
		System.out.println(OUTPUT_COINS_MESSAGE);
		for (int coin : coins.keySet()) {
			System.out.printf(OUTPUT_COINS_INFO, coin, coins.get(coin));
		}
	}

	public String inputMerchandise() {
		System.out.println();
		System.out.println(INPUT_MERCHANDISE_MESSAGE);
		return Console.readLine();
	}

	public String inputPayment() {
		System.out.println();
		System.out.println(INPUT_PAYMENT_MESSAGE);
		return Console.readLine();
	}

	public void printCurrentChanges(int balance) {
		System.out.println();
		System.out.printf(OUTPUT_BALANCE, balance);
	}

	public String inputMerchandiseToBuy() {
		System.out.println(INPUT_BUY_MESSAGE);
		return Console.readLine();
	}

	public void printChangeCoinsCount(Map<Integer, Integer> changesInfo) {
		System.out.println(CHANGES_MESSAGE);
		for (int coin : changesInfo.keySet()) {
			System.out.printf(OUTPUT_COINS_INFO, coin, changesInfo.get(coin));
		}
	}

}
