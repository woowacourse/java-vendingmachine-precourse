package vendingmachine.controller;

import vendingmachine.domain.Vendingmachine;
import vendingmachine.view.HoldingSumInputView;

public class VendingmachineController {

	Vendingmachine vendingmachine;
	HoldingSumInputView holdingSumInputView;

	public VendingmachineController() {
		vendingmachine = new Vendingmachine();
		holdingSumInputView = new HoldingSumInputView();
	}

	public void operate() {
		setHoldingSum();
	}

	private void setHoldingSum() {
		holdingSumInputView.setInput();
		vendingmachine.setHoldingSum(holdingSumInputView.getInput());
	}
}
