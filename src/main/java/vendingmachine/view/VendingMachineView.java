package vendingmachine.view;

import vendingmachine.constants.OutputMessage;
import vendingmachine.model.Coin;
import vendingmachine.model.VendingMachine;

public class VendingMachineView {
	public void printCoinsOfVendingMachine(VendingMachine vendingMachine) {
		System.out.println("\n" + OutputMessage.PREPARED_NUMBER_OF_COINS_MESSAGE);

		for (Coin coin : Coin.values()) {
			System.out.println(coin.getAmount() + "원 - " + vendingMachine.countCoin(coin.ordinal()) + "개");
		}

	}

}
