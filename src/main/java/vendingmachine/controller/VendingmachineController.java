package vendingmachine.controller;

import vendingmachine.model.Vendingmachine;
import vendingmachine.view.HoldingSumView;
import vendingmachine.view.InsertingSumView;
import vendingmachine.view.NameView;
import vendingmachine.view.StockView;

public class VendingmachineController {

	private Vendingmachine vendingmachine;

	private HoldingSumView holdingSumView;
	private StockView stockView;
	private InsertingSumView insertingSumView;
	private NameView nameView;

	public VendingmachineController(Vendingmachine vendingmachine) {
		this.vendingmachine = vendingmachine;
		holdingSumView = new HoldingSumView();
		stockView = new StockView();
		insertingSumView = new InsertingSumView();
		nameView = new NameView();
	}

	public void operate() {
		vendingmachine.setHoldingSum(holdingSumView.getInput());
		holdingSumView.print(vendingmachine.getHoldingSum());

		vendingmachine.setStock(stockView.getInput());

		vendingmachine.setInsertingSum(insertingSumView.getInput());
		insertingSumView.print(vendingmachine.getInsertingSum());
		nameView.getInput();
	}
}
