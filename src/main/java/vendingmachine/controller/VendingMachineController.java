package vendingmachine.controller;

import java.util.LinkedHashMap;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	Money vendingMachineMoney;
	VendingMachine vendingMachine;

	public void play() {
		vendingMachineMoney = new Money(castingStringMoneyToInt(InputView.inputVendingMachieInput()));
		vendingMachine = new VendingMachine(vendingMachineMoney);
		OutputView.showVendingMahcineCoinStatus(castingCoinToInteger(vendingMachine.saveCoinStatus()));
	}

	public int castingStringMoneyToInt(String stringMoney) {
		return Integer.parseInt(stringMoney);
	}

	public LinkedHashMap<Integer, Integer> castingCoinToInteger(LinkedHashMap<Coin, Integer> coinStatus) {
		LinkedHashMap<Integer, Integer> intCoinStatus = new LinkedHashMap<>();
		for (Coin coin : coinStatus.keySet() ) {
			intCoinStatus.put(coin.getAmount(), coinStatus.get(coin));
		}
		return intCoinStatus;
	}


}
