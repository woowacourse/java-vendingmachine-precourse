package vendingmachine.vendingMachine;

import vendingmachine.VendingMachineConsole;

public class VendingMachineController {
    private final VendingMachineService vendingMachineService;
    private final VendingMachineConsole vendingMachineConsole;

    public VendingMachineController(VendingMachineService vendingMachineService, VendingMachineConsole vendingMachineConsole) {
        this.vendingMachineService = vendingMachineService;
        this.vendingMachineConsole = vendingMachineConsole;
    }

    public void on() {
        createCoinBalance();
        createItems();
    }

    private void createCoinBalance() {
        vendingMachineConsole.printCoinBalance(vendingMachineService.createCoinBalance(vendingMachineConsole.inputCoinBalance()));
    }

    private void createItems() {
        vendingMachineService.createItems(vendingMachineConsole.inputItemInventoryInfo());
    }
}
