package vendingmachine.service;

import vendingmachine.constant.Message;
import vendingmachine.model.Vendingmachine;
import vendingmachine.view.ChangeView;
import vendingmachine.view.InsertingSumView;
import vendingmachine.view.NameView;

public class VendingmachineService {

	public Vendingmachine sellProductUntilPossible(Vendingmachine vendingmachine) {

		while (vendingmachine.isPossibleToSell()) {
			vendingmachine = sellProduct(vendingmachine);
		}

		return vendingmachine;
	}

	private Vendingmachine sellProduct(Vendingmachine vendingmachine) {
		InsertingSumView insertingSumView = new InsertingSumView();
		insertingSumView.print(vendingmachine.getInsertingSum());
		NameView nameView = new NameView();
		try {
			vendingmachine.sellProduct(nameView.getInput());
		} catch (IllegalArgumentException e) {
			System.out.println(Message.ERROR + e.getMessage() + "\n");
		}
		return vendingmachine;
	}

	public Vendingmachine giveChange(Vendingmachine vendingmachine) {
		InsertingSumView insertingSumView = new InsertingSumView();
		insertingSumView.print(vendingmachine.getInsertingSum());
		ChangeView changeView = new ChangeView();
		changeView.print(vendingmachine.getChange());
		return vendingmachine;
	}
}
