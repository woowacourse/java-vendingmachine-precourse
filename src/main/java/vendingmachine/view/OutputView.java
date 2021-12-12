package vendingmachine.view;

import java.util.HashMap;

import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.SystemMessage;

public class OutputView {
	public static final String MONEY_UNIT = "원";
	public static final String DASH_DELIMITER = " - ";
	public static final String AMOUNT_UNIT = "개";

	public static void printChangesVendingMachine(VendingMachine vendingMachine) {
		System.out.println();
		System.out.println(SystemMessage.TOTAL_CHANGES.getText());

		HashMap<Coin, Integer> coinMap = vendingMachine.getChanges().getCoinMap();
		for (Coin coin : Coin.values()) {
			System.out.println(coin.getAmount() + MONEY_UNIT + DASH_DELIMITER + coinMap.get(coin) + AMOUNT_UNIT);
		}
	}

	public static void printCurrentInputMoney(VendingMachine vendingMachine) {
		System.out.println();
		System.out.print(SystemMessage.CURRENT_INPUT_MONEY.getText());
		System.out.print(vendingMachine.getInputMoney().getCurrentMoney());
		System.out.println(SystemMessage.MONEY_UNIT_WON.getText());
	}

	public static void printRemainChanges(VendingMachine vendingMachine) {
		System.out.println(SystemMessage.REMAIN_CHANGES.getText());
		for (Coin coin : vendingMachine.getChanges().getRemainChanges()) {
			System.out.print(coin.getAmount() + MONEY_UNIT + DASH_DELIMITER);
			System.out.println(vendingMachine.getChanges().getCoinMap().get(coin) + AMOUNT_UNIT);
		}

	}


}
