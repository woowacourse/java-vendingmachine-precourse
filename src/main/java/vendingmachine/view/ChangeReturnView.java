package vendingmachine.view;

import vendingmachine.domain.money.Money;
import vendingmachine.controller.VendingMachineController;
import vendingmachine.domain.coin.Coins;

public class ChangeReturnView extends VendingMachineView {
	public ChangeReturnView(VendingMachineController controller) {
		super(controller);
	}

	@Override
	public void show() {
		Money insertMoney = controller.getInsertMoney();
		outputProcessor.printInsertMoney(insertMoney);
		Coins coins = controller.showReturnChange();
		outputProcessor.printReturnChange(coins);
		hide();
	}
}
