package vendingmachine.Controller;

import vendingmachine.Model.BeverageGroup;
import vendingmachine.Model.ChangesCoinGroup;
import vendingmachine.Model.CoinGroup;
import vendingmachine.Model.Money;
import vendingmachine.Model.VendingMachine;
import vendingmachine.View.OutputView;

public class MachineController {
	private VendingMachine vendingMachine;

	public MachineController() {
		initiate();
		activate();
		giveChanges();
	}

	private void initiate() {
		CoinGroup coins = new CoinGroup(InputController.getMachineMoney());
		OutputView.printBreak();
		OutputView.printMachineCoin(coins.getMap());
		OutputView.printBreak();
		BeverageGroup beverages = InputController.getBeverageGroup();
		OutputView.printBreak();
		Money userMoney = InputController.getUserMoney(beverages.getMinPrice());
		OutputView.printBreak();
		vendingMachine = new VendingMachine(coins, beverages, userMoney);
	}

	private void activate() {
		OutputView.printUserMoney(vendingMachine.userMoney);
		String beverageNameInput = InputController.getBeverageName(vendingMachine);
		OutputView.printBreak();
		vendingMachine.sell(beverageNameInput);
		if (!vendingMachine.isActivateEnd()) {
			activate();
		}
	}

	private void giveChanges() {
		OutputView.printUserMoney(vendingMachine.userMoney);
		ChangesCoinGroup changesCoins = new ChangesCoinGroup(vendingMachine.coins, vendingMachine.userMoney);
		OutputView.printChanges(changesCoins.getNotEmptyMap());
	}
}
