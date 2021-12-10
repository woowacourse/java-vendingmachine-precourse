package vendingmachine.Controller.Run;

import vendingmachine.Controller.InputController;
import vendingmachine.Controller.MachineController;
import vendingmachine.Model.Product;
import vendingmachine.View.OutputView;

public class Activate {
	private String nameInput;
	private int userMoney;

	public Activate(int userMoney) {
		this.userMoney = userMoney;
		repeatSell();
	}

	public void repeatSell() {
		OutputView.printUserMoney(userMoney);
		setNameInput();
		OutputView.printEmpty();

		sell(MachineController.init.products.find(nameInput));
		if (!isActivateEnd()) {
			repeatSell();
		}
	}

	private void sell(Product product) {
		userMoney -= product.PRICE;
		product.sell();
	}

	private void setNameInput() {
		nameInput = InputController.setWantedProduct(MachineController.init.products.getNames());
	}

	private boolean isActivateEnd() {
		return userMoney < MachineController.init.products.getMinPrice() || MachineController.init.products.allSoldOut();
	}

	public int getUserMoney() {
		return userMoney;
	}
}
