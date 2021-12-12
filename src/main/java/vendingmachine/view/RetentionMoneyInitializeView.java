package vendingmachine.view;

import vendingmachine.VendingMachineController;
import vendingmachine.coin.Coins;

public class RetentionMoneyInitializeView extends VendingMachineView {
	public RetentionMoneyInitializeView(VendingMachineController controller) {
		super(controller);
	}

	@Override
	public void show() {
		String retentionMoney = inputProcessor.readRetentionMoney();
		outputProcessor.printLine();
		try {
			Coins coins = controller.addRetentionCoin(retentionMoney);
			outputProcessor.printRetentionCoins(coins);
			hide();
		} catch (IllegalArgumentException e) {
			outputProcessor.printMessage(e.getMessage());
		}
	}
}
