package vendingmachine.controller;

import vendingmachine.model.VendingMachine;
import vendingmachine.service.GivingChangesService;
import vendingmachine.service.InsertingMoneyService;
import vendingmachine.service.OrderingService;
import vendingmachine.service.SettingCoinService;
import vendingmachine.service.SettingMenuService;
import vendingmachine.view.UserView;
import vendingmachine.view.VendingMachineView;

public class VendingMachineController {
	private VendingMachineView vendingMachineView;
	private UserView userView;
	private OrderingService orderingService;
	private SettingCoinService settingCoinService;
	private SettingMenuService settingMenuService;
	private InsertingMoneyService insertingMoneyService;
	private GivingChangesService givingChangesService;

	public VendingMachineController(VendingMachine vendingMachine) {
		vendingMachineView = new VendingMachineView();
		userView = new UserView();
		orderingService = new OrderingService(vendingMachine, userView, vendingMachineView);
		settingCoinService = new SettingCoinService(vendingMachine, userView, vendingMachineView);
		settingMenuService = new SettingMenuService(vendingMachine, userView, vendingMachineView);
		insertingMoneyService = new InsertingMoneyService(vendingMachine, userView, vendingMachineView);
		givingChangesService = new GivingChangesService(vendingMachine, userView, vendingMachineView);
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
		orderingService.repeatOrder();
	}

	public void giveChangesAtTheEnd() {
		givingChangesService.giveChanges();
	}

}
