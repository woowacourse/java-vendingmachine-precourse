package vendingmachine.job;

import vendingmachine.controller.ChangeSafeController;
import vendingmachine.view.ViewManager;

public class ConsoleChangeSafeJob implements ChangeSafeJob {

	private final ViewManager viewManager;
	private final ChangeSafeController controller;

	public ConsoleChangeSafeJob(ViewManager viewManager, ChangeSafeController controller) {
		this.viewManager = viewManager;
		this.controller = controller;
	}

	@Override
	public void execute() {
		String result = tryExecute();
		viewManager.output(result);
	}

	private String tryExecute() {
		try {
			return controller.generateChangeSafe(viewManager.input());
		} catch (IllegalArgumentException exception) {
			viewManager.error(exception.getMessage());
			return tryExecute();
		}
	}
}
