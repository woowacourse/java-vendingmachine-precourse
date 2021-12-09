package vendingmachine.controller;

import vendingmachine.model.Vendingmachine;
import vendingmachine.view.HoldingSumInputView;

public class VendingmachineController {

	Vendingmachine vendingmachine;
	HoldingSumInputView holdingSumInputView;

	public VendingmachineController() {
		vendingmachine = new Vendingmachine();
		holdingSumInputView = new HoldingSumInputView();
	}

	public void operate() {
		vendingmachine.setHoldingSum(holdingSumInputView.getInput());
		holdingSumInputView.print(vendingmachine.getHoldingSum());
	}
}
