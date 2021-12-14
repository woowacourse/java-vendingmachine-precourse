package vendingmachine.utils;

import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;

public class VendingMachineFactory {

	private VendingMachineFactory() {
	}

	public static VendingMachine makeVendingMachine() {
		int amount = InputView.writeVendingMachineAmount();
		return new VendingMachine(
			CoinCaseFactory.makeCoinCase(amount),
			ProductFactory.makeProducts(),
			InputView.writeInsertMoney());
	}
}
