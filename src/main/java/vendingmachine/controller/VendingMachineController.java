package vendingmachine.controller;

import vendingmachine.domain.Coins;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	public void init() {
		String initialLeftMoney = InputView.getNoticeInputInitialLeftMoney();
		try {
			VendingMachine vendingMachine = VendingMachine.of(initialLeftMoney);
			Coins leftCoins = vendingMachine.getLeftCoins();
			OutputView.showInitialLeftCoins(leftCoins);
		} catch (Exception e) {
			ErrorView.printErrorMesasge(e.getMessage());
			init();
		}
	}
}
