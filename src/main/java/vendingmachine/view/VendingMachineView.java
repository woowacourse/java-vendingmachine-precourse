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

	public void printRemainOfInsertedMoney(int remainMoney) {
		System.out.println("\n" + OutputMessage.PRINT_USER_MONEY + remainMoney + "원");
	}

	public void printChangesComment(int remainMoney) {
		printRemainOfInsertedMoney(remainMoney);
		System.out.println("\n" + OutputMessage.PRINT_CHANGES);
	}

	public void printChanges(int countCoin, Coin coin) {

		if (countCoin != 0) {
			System.out.println(coin.getAmount() + "원 - " + countCoin + "개");
		}

	}

}
