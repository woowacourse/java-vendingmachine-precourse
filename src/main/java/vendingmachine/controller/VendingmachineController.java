package vendingmachine.controller;

import vendingmachine.model.Vendingmachine;
import vendingmachine.view.HoldingSumView;
import vendingmachine.view.StockView;

public class VendingmachineController {

	Vendingmachine vendingmachine;
	HoldingSumView holdingSumView;
	StockView stockView;

	public VendingmachineController() {
		vendingmachine = new Vendingmachine();
		holdingSumView = new HoldingSumView();
		stockView = new StockView();
	}

	public void operate() {
		vendingmachine.setHoldingSum(holdingSumView.getInput());
		holdingSumView.print(vendingmachine.getHoldingSum());

		vendingmachine.setStock(stockView.getInput());
	}
}
