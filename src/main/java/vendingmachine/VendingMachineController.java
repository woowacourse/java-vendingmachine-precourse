package vendingmachine;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;

public class VendingMachineController {

	public void turnOn() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.holdingMoney = InputView.holdingMoneyInput();

	}
}
