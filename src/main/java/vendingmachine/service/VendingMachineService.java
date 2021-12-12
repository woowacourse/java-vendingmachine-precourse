package vendingmachine.service;

import vendingmachine.constants.ErrorMessage;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.UserView;
import vendingmachine.view.VendingMachineView;

public class VendingMachineService {
	public VendingMachine vendingMachine;
	public VendingMachineView vendingMachineView;
	public UserView userView;

	public VendingMachineService(VendingMachine vendingMachine, UserView userView,
		VendingMachineView vendingMachineView) {
		this.vendingMachine = vendingMachine;
		this.vendingMachineView = vendingMachineView;
		this.userView = userView;
	}

	public void repeatOrder() {

		while (!vendingMachine.stopMachine()) {
			vendingMachineView.printRemainOfInsertedMoney(vendingMachine.getRemainMoney());
			order();
		}

	}

	public void order() {
		boolean successOrder = false;
		vendingMachineView.askOrderMenu();

		while (!successOrder) {
			successOrder = orderIfIsRight();
		}

	}

	public boolean orderIfIsRight() {
		try {
			vendingMachine.takeOrder(userView.OrderMenu());
		} catch (IllegalArgumentException e) {
			System.out.println(ErrorMessage.ERROR + e.getMessage());
			return false;
		}
		return true;
	}

}
