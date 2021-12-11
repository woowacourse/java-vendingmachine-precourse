package vendingmachine.controller;

import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

import vendingmachine.model.PossessionCoin;
import vendingmachine.model.PossessionMoney;

public class VendingMachineController {

	PossessionCoin possessionCoin = new PossessionCoin();
	PossessionMoney possessionMoney;

	public void run() {
		inputPossession();
	}

	public void inputPossession() {
		possessionMoney = new PossessionMoney(requestPossessionMoney());
		possessionCoin.createRandomCoins(possessionMoney);
		reportPossessionCoin(possessionCoin);
	}
}
