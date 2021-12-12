package vendingmachine.view;

import vendingmachine.constants.OutputMessage;
import vendingmachine.model.Coin;

public class VendingMachineView {

	public void printInitCoinsComment() {
		System.out.println("\n" + OutputMessage.PREPARED_NUMBER_OF_COINS_MESSAGE);
	}

	public void printCoin(int countCoin, Coin coin) {
		System.out.println(coin.getAmount() + "원 - " + countCoin + "개");
	}

	public void printRemainOfInsertedMoney(int remainMoney) {
		System.out.println("\n" + OutputMessage.PRINT_USER_MONEY + remainMoney + "원");
	}

	public void printChangesComment(int remainMoney) {
		printRemainOfInsertedMoney(remainMoney);
		System.out.println(OutputMessage.PRINT_CHANGES);
	}

}
