package vendingmachine.view;

import java.util.Map;

import vendingmachine.Coin;
import vendingmachine.domain.Changes;
import vendingmachine.domain.Money;

public class OutputView {
	private static final String VENDING_MACHINE_CHANGES_UI = "자판기가 보유한 동전";
	private static final String INSERT_MONEY_UI = "투입 금액: ";

	public static void vendingMachineChanges(Changes changes) {
		System.out.println(VENDING_MACHINE_CHANGES_UI);
		for (Map.Entry<Coin, Integer> coinIntegerEntry : changes.getChanges().entrySet()) {
			System.out.printf("%d원 - %d개\n",
				coinIntegerEntry.getKey().getAmount(), coinIntegerEntry.getValue());
		}
	}

	public static void insertMoneyUI(Money insertMoney) {
		System.out.println(INSERT_MONEY_UI + insertMoney.getAmount() + "원");
	}
}
