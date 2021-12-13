package vendingmachine;

public class VendingMachineController {
    private final VendingMachineService vendingMachineService;
    private final VendingMachineConsole vendingMachineConsole;

    public VendingMachineController(VendingMachineService vendingMachineService, VendingMachineConsole vendingMachineConsole) {
        this.vendingMachineService = vendingMachineService;
        this.vendingMachineConsole = vendingMachineConsole;
    }

    public void on() {
        createVendingMachine();
        createCoinBalance();
        createItems();
    }

    private void createVendingMachine() {
        vendingMachineService.createVendingMachine();
    }

    private void createCoinBalance() {
        vendingMachineConsole.printCoinBalance(vendingMachineService.createCoinBalance(vendingMachineConsole.inputCoinBalance()));
    }

    private void createItems() {
        vendingMachineService.createItems(vendingMachineConsole.inputItemInventoryInfo());
    }
}
