package vendingmachine.view;

import vendingmachine.constants.InputMessage;

public class UserView {
	public void askVendingMachineCoins() {
		System.out.println(InputMessage.PREPARING_COIN_MESSAGE);
	}

	public void askProductsInfo() {
		System.out.println(InputMessage.INPUT_MENU_MESSAGE);
	}
}
