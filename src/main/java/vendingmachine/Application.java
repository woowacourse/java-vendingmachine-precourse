package vendingmachine;

import vendingmachine.controller.PurchaseController;
import vendingmachine.service.PurchaseService;
import vendingmachine.domain.vendingMachine.VendingMachine;
import vendingmachine.controller.VendingMachineController;
import vendingmachine.service.VendingMachineService;

public class Application {
    private static final ApplicationConsole APPLICATION_CONSOLE = new ApplicationConsole();
    private static final VendingMachine vendingMachine = new VendingMachine();
    private static final VendingMachineService vendingMachineService = new VendingMachineService(vendingMachine);
    private static final PurchaseService purchaseService = new PurchaseService(vendingMachine);
    private static final VendingMachineController vendingMachineController = new VendingMachineController(vendingMachineService, APPLICATION_CONSOLE);
    private static final PurchaseController purchaseController = new PurchaseController(purchaseService, APPLICATION_CONSOLE);

    public static void main(String[] args) {
        vendingMachineController.on();
        purchaseController.start();
    }
}
