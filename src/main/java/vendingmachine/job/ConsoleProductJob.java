package vendingmachine.job;

import vendingmachine.controller.ProductController;
import vendingmachine.view.ViewManager;

public class ConsoleProductJob implements ProductJob {

	private final ViewManager viewManager;
	private final ProductController controller;

	public ConsoleProductJob(ViewManager viewManager, ProductController controller) {
		this.viewManager = viewManager;
		this.controller = controller;
	}

	@Override
	public void execute() {
		tryExecute();
	}

	private void tryExecute() {
		try {
			controller.generateProducts(viewManager.input());
		} catch (IllegalArgumentException exception) {
			viewManager.error(exception.getMessage());
			tryExecute();
		}
	}
}
