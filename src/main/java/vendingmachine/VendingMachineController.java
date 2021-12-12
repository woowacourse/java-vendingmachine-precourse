package vendingmachine;

import vendingmachine.domain.Coins;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	OutputView outputView = new OutputView();

	public void turnOn() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.holdingMoney = InputView.holdingMoneyInput();
		vendingMachine.getCoins();
		outputView.printHoldingCoins(Coins.getCoins());
	}



}
