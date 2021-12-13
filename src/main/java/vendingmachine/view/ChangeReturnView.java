package vendingmachine.view;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.money.Money;

public class ChangeReturnView extends VendingMachineView {
	public ChangeReturnView(VendingMachineController controller) {
		super(controller);
	}

	@Override
	public void show() {
		Money insertMoney = controller.getInsertMoney();
		outputProcessor.printInsertMoney(insertMoney);
		Coins coins = controller.createReturnChange();
		outputProcessor.printReturnChange(coins);
		hide();
	}
}
