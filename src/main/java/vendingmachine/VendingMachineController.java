package vendingmachine;

import vendingmachine.coin.Coins;

public class VendingMachineController {
	private final VendingMachineService vendingMachineService = new VendingMachineService();

	public Coins showRetentionCoin(String retentionAmount) {
		Money retentionMoney = Money.of(retentionAmount);
		return vendingMachineService.generateCoin(retentionMoney);
	}


}
