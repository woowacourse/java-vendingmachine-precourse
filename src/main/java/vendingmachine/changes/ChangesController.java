package vendingmachine.changes;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class ChangesController {
	private Changes changes;

	public ChangesController() {
		changes = new Changes();
	}

	public Changes readyToChanges() {
		InputView.printInitialMoneySettingMessage();
		requestInitialMoney();
		return changes;
	}

	private void requestInitialMoney() {
		try {
			changes.input(Console.readLine());
			changes.createRandomCoins();
			OutputView.printVendingMachineOwnCoins(changes.getCoins());
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.showMessage(illegalArgumentException);
			requestInitialMoney();
		}
	}
}
