package vendingmachine.controller;

import vendingmachine.model.VendingMachine;
import vendingmachine.service.VendingMachineService;

public class VendingMachineController {
	public VendingMachineService vendingMachineService;

	public VendingMachineController(VendingMachine vendingMachine) {
		vendingMachineService = new VendingMachineService(vendingMachine);
	}

	public void setInitCoins() {
		vendingMachineService.setInitCoins();
		vendingMachineService.printInitCoins();
	}

	public void setMenuList() {
		vendingMachineService.setMenuList();
	}

	public void insertMoney() {
		vendingMachineService.insertMoney();
	}

	public void orderUntilEnd() {
		vendingMachineService.repeatOrder();
	}

	public void giveChangesAtTheEnd() {
		vendingMachineService.giveChanges();
	}

}
