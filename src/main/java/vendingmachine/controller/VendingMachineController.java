package vendingmachine.controller;

import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

import vendingmachine.domain.VendingMachine;

public class VendingMachineController {
	public void run() {
		VendingMachine vendingMachine = new VendingMachine(inputHoldingAmountMoney());
		printHoldingAmountCoin(vendingMachine.getHoldingAmountCoins());
	}
}
