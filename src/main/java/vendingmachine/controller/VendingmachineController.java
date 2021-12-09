package vendingmachine.controller;

import vendingmachine.domain.Vendingmachine;
import vendingmachine.view.HoldingSumInputView;

public class VendingmachineController {

	Vendingmachine vendingmachine;
	HoldingSumInputView holdingSumInputView;

	public VendingmachineController() {
		holdingSumInputView = new HoldingSumInputView();
		vendingmachine = new Vendingmachine();
	}

	public void operate() {
		setHoldingSum();
	}

	private void setHoldingSum() {
		holdingSumInputView.setInput();
		System.out.println(holdingSumInputView.getInput());
	}
}
