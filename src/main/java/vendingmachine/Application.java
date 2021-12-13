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

		Products productList = new ProductListManager().getList();
		DepositManager depositManager = new DepositManager();
		new OrderManager(productList, depositManager).run();

		depositManager.printDeposit();
		coinListManager.returnChange(depositManager.getDeposit());
	}
}
