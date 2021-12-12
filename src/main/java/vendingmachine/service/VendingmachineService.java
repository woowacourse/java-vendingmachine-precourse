package vendingmachine.service;

import vendingmachine.model.Vendingmachine;
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
		vendingmachine.sellProduct(nameView.getInput());
		return vendingmachine;
	}
}
