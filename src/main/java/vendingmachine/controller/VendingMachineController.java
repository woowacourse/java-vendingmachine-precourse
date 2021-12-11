package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.service.VendingMachineManagement;

public class VendingMachineController {
	private VendingMachine vendingMachine;
	private VendingMachineManagement management;
	private Administrator administrator;
	private Consumer consumer;

	public VendingMachineController(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
		this.management = new VendingMachineManagement(vendingMachine);
	}

	public void start() {
		createAdministrator();

		setCoins();
		showCoins();
	}

	private void createAdministrator() {
		administrator = new Administrator(this.vendingMachine);
	}

	private void setCoins() {
		management.noticeInsertMoneyOfChanges();

		String input = administrator.getMoneyOfChanges();
		management.insertMoneyOfChanges(Integer.parseInt(input));
	}

	private void showCoins() {
		management.noticeCountOfCoins();
	}

	// 소비자 관련
}
