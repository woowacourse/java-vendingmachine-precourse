package vendingmachine.service;

import vendingmachine.model.Coin;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.UserView;
import vendingmachine.view.VendingMachineView;

public class GivingChangesService {
	private VendingMachine vendingMachine;
	private UserView userView;
	private VendingMachineView vendingMachineView;

	public GivingChangesService(VendingMachine vendingMachine, UserView userView,
		VendingMachineView vendingMachineView) {
		this.vendingMachine = vendingMachine;
		this.userView = userView;
		this.vendingMachineView = vendingMachineView;
	}

	public void giveChanges() {
		vendingMachineView.printChangesComment(vendingMachine.getRemainMoney());

		for (Coin coin : Coin.values()) {
			int changes = vendingMachine.giveChanges(coin);

			if (changes != 0) {
				vendingMachineView.printCoin(changes, coin);
			}

		}

	}

}
