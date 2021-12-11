package vendingmachine.Controller.Run;

import vendingmachine.Controller.InputController;
import vendingmachine.Controller.MachineController;
import vendingmachine.Model.Product;
import vendingmachine.Model.VendingMachine;
import vendingmachine.View.OutputView;

public class Activate {
	private String nameInput;
	private final VendingMachine vendingMachine;

	public Activate(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
		repeatSell();
	}

	public void repeatSell() {
		OutputView.printUserMoney(vendingMachine.userMoney);
		setNameInput();
		OutputView.printEmpty();

		sell(vendingMachine.productList.find(nameInput));
		if (!isActivateEnd()) {
			repeatSell();
		}
	}

	private void sell(Product product) {
		vendingMachine.userMoney -= product.PRICE;
		product.sell();
	}

	private void setNameInput() {
		nameInput = InputController.setWantedProduct(vendingMachine);
	}

	private boolean isActivateEnd() {
		return vendingMachine.isUserPoor() || vendingMachine.allSoldOut();
	}
}
