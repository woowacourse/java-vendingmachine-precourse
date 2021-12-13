package vendingmachine.job;

import vendingmachine.controller.ChangeBackController;
import vendingmachine.view.ViewManager;

public class ConsoleChangeBackJob implements ChangeBackJob {

	private final ViewManager viewManager;
	private final ChangeBackController controller;

	public ConsoleChangeBackJob(ViewManager viewManager, ChangeBackController controller) {
		this.viewManager = viewManager;
		this.controller = controller;
	}

	@Override
	public void execute() {
		viewManager.output(controller.retrieveChangeSafe());
	}
}
