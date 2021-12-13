package vendingmachine;

import userinterface.CoinListManager;
import userinterface.DepositManager;
import userinterface.OrderManager;
import userinterface.ProductListManager;

public class Application {
	public static void main(String[] args) {
		CoinListManager coinListManager = new CoinListManager(new Coins());
		coinListManager.makeRandomList();
		coinListManager.printCoinList();

		DepositManager depositManager = new DepositManager();
		OrderManager orderManager = new OrderManager(new ProductListManager().getList(), depositManager);
		orderManager.run();

		depositManager.printDeposit();
		coinListManager.returnChange(depositManager.getDeposit());
	}
}
