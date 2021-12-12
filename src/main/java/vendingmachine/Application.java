package vendingmachine;

import vendingmachine.config.AppConfig;

public class Application {
	public static void main(String[] args) {
		Application app = new Application();
		VendingMachine vendingMachine = AppConfig.getVendingMachine();
		app.run(vendingMachine);
	}

	private void run(VendingMachine vendingMachine) {
		vendingMachine.start();
	}
}
