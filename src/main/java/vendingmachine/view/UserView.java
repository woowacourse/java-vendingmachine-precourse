package vendingmachine.view;

import vendingmachine.constants.InputMessage;

public class UserView {
	public void askVendingMachineCoins() {
		System.out.println(InputMessage.PREPARING_COIN_MESSAGE);
	}

	public void askProductsInfo() {
		System.out.println("\n" + InputMessage.INPUT_MENU_MESSAGE);
	}

	public void askInsertMoney() {
		System.out.println("\n" + InputMessage.INSERT_MONEY_MESSAGE);
	}
}
