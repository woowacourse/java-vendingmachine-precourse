package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.view.InputView;

public class VendingMachineController {
	Money vendingMachineMoney;

	public void play() {
		vendingMachineMoney = new Money(castingStringMoneyToInt(InputView.inputVendingMachieInput()));
	}

	public int castingStringMoneyToInt(String stringMoney) {
		return Integer.parseInt(stringMoney);
	}


}
