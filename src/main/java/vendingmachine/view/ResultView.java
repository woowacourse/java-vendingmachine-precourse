package vendingmachine.view;

import java.util.ArrayList;
import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;

public class ResultView {
	private static final String PRINT_VENDING_MONEY = "\n자판기가 보유한 동전";
	private static final String PRINT_NO_CHANGES = "잔돈이 없습니다.";
	private static final String PRINT_MONEY_AMOUNT = "개";
	private static final String PRINT_CHANGE_COIN = "잔돈";
	private static final String PRINT_LEFT_INSERT_MONEY = "투입 금액: ";

	public static void printVendingMachineCoin(VendingMachine vendingMachine) {
		System.out.println(PRINT_VENDING_MONEY);
		Map<Coin, Integer> coinMap = vendingMachine.getChanges().getCoinMap();
		printChanges(coinMap);
	}

	public static void printChanges(Map<Coin, Integer> changes) {
		new ArrayList<>(changes.keySet())
			.forEach(coin -> System.out.println(coin.toString() + changes.get(coin) + PRINT_MONEY_AMOUNT));
	}


	public static void printInsertMoney(VendingMachine vendingMachine) {
		System.out.println(PRINT_LEFT_INSERT_MONEY + vendingMachine.getMoney());
	}

	public static void printVendingMachineReturnChanges(VendingMachine vendingMachine) {
		System.out.println(PRINT_CHANGE_COIN);
		Map<Coin, Integer> returnChanges = vendingMachine.getReturnChanges();
		if (returnChanges == null) {
			System.out.println(PRINT_NO_CHANGES);
			return;
		}
		printChanges(returnChanges);
	}
}