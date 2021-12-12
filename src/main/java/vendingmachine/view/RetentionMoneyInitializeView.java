package vendingmachine.view;

import vendingmachine.VendingMachineController;
import vendingmachine.coin.Coins;

public class RetentionMoneyInitializeView extends View {
	private final VendingMachineController controller = new VendingMachineController();

	public void show() {
		String retentionMoney = inputProcessor.readRetentionMoney();
		Coins coins = controller.addRetentionCoin(retentionMoney);
		outputProcessor.printRetentionCoins(coins);
	}
}
