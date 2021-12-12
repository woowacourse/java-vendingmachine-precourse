package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.menu.Menus;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private VendingMachine vendingMachine;

	public void init() {
		try {
			initVendingMachine();
			buyItems();
			returnChanges();
		} catch (Exception e) {
			ErrorView.printErrorMesasge(e.getMessage());
			init();
		}
	}

	private void initVendingMachine() {
		Coins leftCoins = initCoins();
		Menus menus = initMenus();
		vendingMachine = new VendingMachine(leftCoins, menus);

		putMoneyToVendingMachine();
	}

	private Coins initCoins() {
		String initialLeftMoney = InputView.getInitialLeftMoney();
		Coins leftCoins = Coins.generateCoinsRandomlyFromTotalAmount(initialLeftMoney);
		OutputView.showInitialLeftCoins(leftCoins);
		return leftCoins;
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

	private void putMoneyToVendingMachine() {
		try {
			String inputMoney = InputView.getMoney();
			vendingMachine.putMoney(inputMoney);
		} catch (Exception e) {
			ErrorView.printErrorMesasge(e.getMessage());
			putMoneyToVendingMachine();
		}
	}

	private void buyItems() {
		while (vendingMachine.canBuy()) {
			showLeftMoney();
			buyItem();
		}
	}

	private void showLeftMoney() {
		int leftInputMoney = vendingMachine.getInputMoney();
		InputView.showLeftMoney(leftInputMoney);
	}

	private void buyItem() {
		String menuToBuy = InputView.getMenuToBuy();
		try {
			vendingMachine.buy(menuToBuy);
		} catch (Exception e) {
			ErrorView.printErrorMesasge(e.getMessage());
			buyItem();
		}
	}

	private void returnChanges() {
		showLeftMoney();
		Coins changes = vendingMachine.returnChanges();
		OutputView.showChanges(changes);
	}
}
