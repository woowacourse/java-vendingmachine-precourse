package vendingmachine.model;

import java.util.Map;

import vendingmachine.controller.BalanceController;
import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.BalanceMessage;

public class Operation {

	public static void turnOn() {
		BalanceMessage.printInputMessage();
		int balance = BalanceController.getInputValue();

		VendingMachine vendingMachine = VendingMachine.create();
		Map<Coin, Integer> coinMap = vendingMachine.decideCoinRandomly(Coin.values(), balance);
		BalanceMessage.printCoinList(coinMap);
	}
}
