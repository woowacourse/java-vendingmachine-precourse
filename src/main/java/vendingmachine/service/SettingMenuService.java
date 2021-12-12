package vendingmachine.service;

import vendingmachine.constants.ErrorMessage;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.UserView;
import vendingmachine.view.VendingMachineView;

public class SettingMenuService {
	private VendingMachine vendingMachine;
	private UserView userView;
	private VendingMachineView vendingMachineView;

	public SettingMenuService(VendingMachine vendingMachine, UserView userView, VendingMachineView vendingMachineView) {
		this.vendingMachine = vendingMachine;
		this.userView = userView;
		this.vendingMachineView = vendingMachineView;
	}

	public void setMenuList() {
		boolean successSetMenuList = false;
		vendingMachineView.askProductsInfo();

		while (!successSetMenuList) {
			successSetMenuList = setMenuListIfItIsRight();
		}

	}

	public boolean setMenuListIfItIsRight() {
		try {
			vendingMachine.setMenu(userView.insertProductsInfo());
		} catch (IllegalArgumentException e) {
			System.out.println(ErrorMessage.ERROR + e.getMessage());
			return false;
		}
		return true;
	}

}
