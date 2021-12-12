package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constants.InputMessage;

public class UserView {
	public void askInitCoins() {
		System.out.println(InputMessage.PREPARING_COIN_MESSAGE);
	}

	public String insertInitCoins() {
		String initCoin = Console.readLine();
		return initCoin;
	}

	public void askProductsInfo() {
		System.out.println("\n" + InputMessage.INPUT_MENU_MESSAGE);
	}

	public String insertProductsInfo() {
		String productInfo = Console.readLine();
		return productInfo;
	}

	public void askInsertMoney() {
		System.out.println("\n" + InputMessage.INSERT_MONEY_MESSAGE);
	}

	public String insertMoney() {
		String insertedMoney = Console.readLine();
		return insertedMoney;
	}

	public void orderMenu() {
		System.out.println(InputMessage.ORDER_MENU_NAME);
	}

}
