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

			String inputMoney = InputView.getMoney();
			vendingMachine.putMoney(inputMoney);

			while (true) {
				showLeftMoney(vendingMachine);

				if (vendingMachine.canBuy()) {
					buyItem(vendingMachine);
					continue;
				}

				Coins changes = vendingMachine.returnChanges();
				OutputView.showChanges(changes);
				break;
			}

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

	private void showLeftMoney(VendingMachine vendingMachine) {
		int leftInputMoney = vendingMachine.getInputMoney();
		InputView.showLeftMoney(leftInputMoney);
	}

	private void buyItem(VendingMachine vendingMachine) {
		String menuToBuy = InputView.getMenuToBuy();
		try {
			vendingMachine.buy(menuToBuy);
		} catch (Exception e) {
			ErrorView.printErrorMesasge(e.getMessage());
			buyItem(vendingMachine);
		}
	}
}
