package vendingmachine.view;

import vendingmachine.constants.InputMessage;
import vendingmachine.constants.OutputMessage;
import vendingmachine.model.Coin;

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

	public void orderMenu() {
		System.out.println(InputMessage.ORDER_MENU_NAME);
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
