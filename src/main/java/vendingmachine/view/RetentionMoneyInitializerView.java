package vendingmachine.view;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.domain.coin.Coins;

public class RetentionMoneyInitializerView extends VendingMachineView {
	public RetentionMoneyInitializerView(VendingMachineController controller) {
		super(controller);
	}

	@Override
	public void show() {
		String retentionMoney = inputProcessor.readRetentionMoney();
		outputProcessor.printLine();
		try {
			Coins coins = controller.addRetentionCoins(retentionMoney);
			outputProcessor.printRetentionCoins(coins);
			hide();
		} catch (IllegalArgumentException e) {
			outputProcessor.printMessage(e.getMessage());
		}
	}
}
