package vendingmachine.controller;

import vendingmachine.repository.Change;
import vendingmachine.service.ChangeService;
import vendingmachine.view.CoinView;

public class ChangeController {
	public static void setChange() {
		ChangeService.calculateChange();
	}

	public static void printChange() {
		CoinView.printChange();
		CoinView.printCoinMap(Change.getChange());
	}
}
