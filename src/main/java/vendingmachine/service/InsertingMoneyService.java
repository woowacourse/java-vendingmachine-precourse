package vendingmachine.service;

import vendingmachine.constants.ErrorMessage;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.UserView;
import vendingmachine.view.VendingMachineView;

public class InsertingMoneyService {
	private VendingMachine vendingMachine;
	private UserView userView;
	private VendingMachineView vendingMachineView;

	public InsertingMoneyService(VendingMachine vendingMachine, UserView userView,
		VendingMachineView vendingMachineView) {
		this.vendingMachine = vendingMachine;
		this.userView = userView;
		this.vendingMachineView = vendingMachineView;
	}

	public void insertMoney() {
		boolean successInsertMoney = false;
		vendingMachineView.askInsertMoney();

		while (!successInsertMoney) {
			successInsertMoney = insertMoneyIfItIsRight();
		}

	}

	public boolean insertMoneyIfItIsRight() {
		try {
			vendingMachine.insertMoney(userView.insertMoney());
		} catch (IllegalArgumentException e) {
			System.out.println(ErrorMessage.ERROR + e.getMessage());
			return false;
		}
		return true;
	}

}
