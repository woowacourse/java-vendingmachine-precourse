package vendingmachine;

public class Application {
    private static final VendingMachineConsole vendingMachineConsole = new VendingMachineConsole();
    private static final VendingMachineService vendingMachineService = new VendingMachineService();
    private static final PurchaseService purchaseService = new PurchaseService(vendingMachineService);
    private static final VendingMachineController vendingMachineController = new VendingMachineController(vendingMachineService, vendingMachineConsole);
    private static final PurchaseController purchaseController = new PurchaseController(purchaseService, vendingMachineConsole);

    public static void main(String[] args) {
        vendingMachineController.on();
        purchaseController.start();
    }
}
