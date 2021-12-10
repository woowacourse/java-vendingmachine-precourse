package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;

public class VendingMachineController {
	public void init() {
		String initialLeftMoney = InputView.getNoticeInputInitialLeftMoney();
		try {
			VendingMachine vendingMachine = new VendingMachine(initialLeftMoney);
		} catch (Exception e) {
			ErrorView.printErrorMesasge(e.getMessage());
			init();
		}
	}
}
