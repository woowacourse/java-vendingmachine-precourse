package vendingmachine.service;

import vendingmachine.constant.Message;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.ChangeView;
import vendingmachine.view.InsertingSumView;
import vendingmachine.view.NameView;

public class VendingMachineService {

	public VendingMachine sellProductUntilPossible(VendingMachine vendingMachine) {

		while (vendingMachine.isPossibleToSell()) {
			vendingMachine = sellProduct(vendingMachine);
		}

		return vendingMachine;
	}

	private VendingMachine sellProduct(VendingMachine vendingMachine) {
		InsertingSumView insertingSumView = new InsertingSumView();
		insertingSumView.print(vendingMachine.getInsertingSum());
		NameView nameView = new NameView();
		try {
			vendingMachine.sellProduct(nameView.getInput());
		} catch (IllegalArgumentException e) {
			System.out.println(Message.ERROR + e.getMessage() + "\n");
		}
		return vendingMachine;
	}

	public VendingMachine giveChange(VendingMachine vendingMachine) {
		InsertingSumView insertingSumView = new InsertingSumView();
		insertingSumView.print(vendingMachine.getInsertingSum());
		ChangeView changeView = new ChangeView();
		changeView.print(vendingMachine.getChange());
		return vendingMachine;
	}
}
