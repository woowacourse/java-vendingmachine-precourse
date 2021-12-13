package vendingmachine.controller;

import java.util.Map;

import vendingmachine.domain.Change;
import vendingmachine.domain.Coin;
import vendingmachine.service.ChangeService;
import vendingmachine.view.VendingMachineAccountView;

public class ChangeController {
	private static final String CHANGE_MESSAGE = "잔돈";

	public static void setChange() {

		ChangeService.calculateChange();
	}

	public static void printChange() {
		System.out.println(CHANGE_MESSAGE);
		Map<Coin, Integer> change = Change.getChange();
		VendingMachineAccountView.printCoinMap(change);
	}
}
