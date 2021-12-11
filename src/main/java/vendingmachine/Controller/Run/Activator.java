package vendingmachine.Controller.Run;

import vendingmachine.Model.Product;
import vendingmachine.Model.VendingMachine;

public class Activator {
	private final VendingMachine vendingMachine;

	public Activator(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void sell(Product product) {
		vendingMachine.userMoney -= product.PRICE;
		product.sell();
	}

	public boolean isActivateEnd() {
		return vendingMachine.isUserPoor() || vendingMachine.allSoldOut();
	}
}
