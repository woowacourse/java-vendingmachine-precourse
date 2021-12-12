package vendingmachine.view;

import vendingmachine.coin.Coins;

public class RetentionMoneyInitializeView extends VendingMachineView {
	@Override
	public void show() {
		String retentionMoney = inputProcessor.readRetentionMoney();
		Coins coins = controller.addRetentionCoin(retentionMoney);
		outputProcessor.printRetentionCoins(coins);
	}
}
