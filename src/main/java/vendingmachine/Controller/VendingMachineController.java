package vendingmachine.Controller;

import java.util.HashMap;

import vendingmachine.Model.Coin;

public class VendingMachineController {
	private int machineMoney;
	private HashMap<Coin, Integer> machineCoins = new HashMap<>();

	public VendingMachineController() {
		set();
	}

	private void set() {
		machineMoney = InputController.setMoney();

		for (Coin coin : Coin.values()) {
			int divisor = coin.getAmount();
			machineCoins.put(coin, machineMoney / divisor);
			machineMoney %= divisor;
		}
	}
}
