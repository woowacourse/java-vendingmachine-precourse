package vendingmachine.controller;

import vendingmachine.model.VendingMachine;
import vendingmachine.service.InsertingMoneyService;
import vendingmachine.service.SettingCoinService;
import vendingmachine.service.SettingMenuService;
import vendingmachine.service.VendingMachineService;
import vendingmachine.view.UserView;
import vendingmachine.view.VendingMachineView;

public class VendingMachineController {
	private VendingMachineService vendingMachineService;
	private VendingMachineView vendingMachineView;
	private UserView userView;
	private SettingCoinService settingCoinService;
	private SettingMenuService settingMenuService;
	private InsertingMoneyService insertingMoneyService;

	public VendingMachineController(VendingMachine vendingMachine) {
		vendingMachineView = new VendingMachineView();
		userView = new UserView();
		vendingMachineService = new VendingMachineService(vendingMachine, userView, vendingMachineView);
		settingCoinService = new SettingCoinService(vendingMachine, userView, vendingMachineView);
		settingMenuService = new SettingMenuService(vendingMachine, userView, vendingMachineView);
		insertingMoneyService = new InsertingMoneyService(vendingMachine, userView, vendingMachineView);
	}

	public void setInitCoins() {
		settingCoinService.setInitCoins();
		settingCoinService.printInitCoins();
	}

	public void setMenuList() {
		settingMenuService.setMenuList();
	}

	public void insertMoney() {
		insertingMoneyService.insertMoney();
	}

	public void orderUntilEnd() {
		vendingMachineService.repeatOrder();
	}

	public void giveChangesAtTheEnd() {
		vendingMachineService.giveChanges();
	}

}
