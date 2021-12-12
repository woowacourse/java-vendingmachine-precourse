package vendingmachine.view;

import vendingmachine.Money;
import vendingmachine.coin.Coins;

public class ChangeReturnView extends VendingMachineView {
	@Override
	public void show() {
		Money insertMoney = controller.getInsertMoney();
		outputProcessor.printInsertMoney(insertMoney);
		Coins coins = controller.showReturnChange();
		outputProcessor.printReturnChange(coins);
	}
}
