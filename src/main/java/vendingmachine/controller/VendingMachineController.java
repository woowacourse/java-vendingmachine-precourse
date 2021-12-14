package vendingmachine.controller;

import vendingmachine.ApplicationConsole;
import vendingmachine.service.VendingMachineService;

public class VendingMachineController {
    private final VendingMachineService vendingMachineService;
    private final ApplicationConsole applicationConsole;

    public VendingMachineController(VendingMachineService vendingMachineService, ApplicationConsole applicationConsole) {
        this.vendingMachineService = vendingMachineService;
        this.applicationConsole = applicationConsole;
    }

    public void on() {
        createCoinBalance();
        createItems();
    }

    private void createCoinBalance() {
        applicationConsole.printCoinBalance(vendingMachineService.createCoinBalance(applicationConsole.inputCoinBalance()));
    }

    private void createItems() {
        vendingMachineService.createItems(applicationConsole.inputItemInventoryInfo());
    }
}
