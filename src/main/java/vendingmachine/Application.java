package vendingmachine;

import vendingmachine.controller.MachineController;

public class Application {

	private final AppConfig appConfig = AppConfig.getInstance();

	public static void main(String[] args) {
		Application application = new Application();
		application.run();
	}

	public void run() {
		MachineController machineController = appConfig.machineController;
		initVendingMachine(machineController);
		purchaseProduct(machineController);
	}

	private void initVendingMachine(MachineController machineController) {
		machineController.fillWithCoins();
		machineController.showCoinsOfMachine();
		machineController.registerProducts();
	}

	private void purchaseProduct(MachineController machineController) {
		machineController.depositMoney();
		machineController.purchaseProducts();
		machineController.refundMoneyOfUser();
	}

}
