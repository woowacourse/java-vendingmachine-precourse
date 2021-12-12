package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class UserView {
	public String insertInitCoins() {
		String initCoin = Console.readLine();
		return initCoin;
	}

	public String insertProductsInfo() {
		String productInfo = Console.readLine();
		return productInfo;
	}

	public String insertMoney() {
		String insertedMoney = Console.readLine();
		return insertedMoney;
	}
	
	public String OrderMenu() {
		String orderedMenu = Console.readLine();
		return orderedMenu;
	}

}
