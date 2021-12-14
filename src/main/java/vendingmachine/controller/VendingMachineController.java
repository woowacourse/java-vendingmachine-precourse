package vendingmachine.controller;

import vendingmachine.model.VendingMachine;
import vendingmachine.service.VendingMachineService;
import vendingmachine.view.HoldingSumView;
import vendingmachine.view.InsertingSumView;
import vendingmachine.view.StockView;

public class VendingMachineController {

	private VendingMachine vendingMachine;
	private HoldingSumView holdingSumView;
	private StockView stockView;
	private InsertingSumView insertingSumView;
	private VendingMachineService vendingMachineService;

	public VendingMachineController(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
		holdingSumView = new HoldingSumView();
		stockView = new StockView();
		insertingSumView = new InsertingSumView();
		vendingMachineService = new VendingMachineService();
	}

	public void operate() {
		vendingMachine.setHoldingSum(holdingSumView.getInput());
		holdingSumView.print(vendingMachine.getHoldingSum());
		vendingMachine.setStock(stockView.getInput());
		vendingMachine.setInsertingSum(insertingSumView.getInput());
		vendingMachine = vendingMachineService.sellProductUntilPossible(vendingMachine);
		vendingMachine = vendingMachineService.giveChange(vendingMachine);
	}
}
