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
			VendingMachine vendingMachine = VendingMachine.from(initialLeftMoney);
			Coins leftCoins = vendingMachine.getLeftCoins();
			OutputView.showInitialLeftCoins(leftCoins);

			String menuInfos = InputView.getMenuInfo();
			Menus menus = Menus.from(menuInfos);
		} catch (Exception e) {
			ErrorView.printErrorMesasge(e.getMessage());
			init();
		}
	}
}
