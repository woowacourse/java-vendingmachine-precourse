package vendingmachine.job;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.controller.DepositController;
import vendingmachine.view.ViewManager;

public class ConsoleDepositJob implements DepositJob {

	private final ViewManager viewManager;
	private final DepositController controller;

	public ConsoleDepositJob(ViewManager viewManager, DepositController controller) {
		this.viewManager = viewManager;
		this.controller = controller;
	}

	@Override
	public void execute() {
		tryExecute();
	}

	private void tryExecute() {
		try {
			controller.depositMoney(viewManager.input());
		} catch (IllegalArgumentException exception) {
			viewManager.error(exception.getMessage());
			tryExecute();
		}
	}

}
