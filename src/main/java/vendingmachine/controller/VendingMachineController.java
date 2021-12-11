package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.menu.Menus;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	public void init() {
		String initialLeftMoney = InputView.getInitialLeftMoney();
		try {
			Coins leftCoins = Coins.generateCoinsRandomlyFromTotalAmount(initialLeftMoney);
			OutputView.showInitialLeftCoins(leftCoins);

			Menus menus = initMenus();

			VendingMachine vendingMachine = new VendingMachine(leftCoins, menus);
		} catch (Exception e) {
			ErrorView.printErrorMesasge(e.getMessage());
			init();
		}
	}

	private Menus initMenus() {
		try {
			String menuInfos = InputView.getMenuInfo();
			return Menus.from(menuInfos);
		} catch (Exception e) {
			ErrorView.printErrorMesasge(e.getMessage());
			return initMenus();
		}
	}
}
