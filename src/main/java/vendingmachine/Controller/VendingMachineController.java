package vendingmachine.Controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

import vendingmachine.Model.Coin;
import vendingmachine.View.OutputView;

public class VendingMachineController {
	private int machineMoney;
	private LinkedHashMap<Coin, Integer> machineCoins = new LinkedHashMap<>();

	public VendingMachineController() {
		set();
		OutputView.printCoin(machineCoins);
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
