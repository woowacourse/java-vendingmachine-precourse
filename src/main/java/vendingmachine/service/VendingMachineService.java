package vendingmachine.service;

import vendingmachine.model.Changes;
import vendingmachine.model.DisplayMerchandise;
import vendingmachine.model.VendingMachine;

public class VendingMachineService {
    private VendingMachine vendingMachine;

    public void createVendingMachine(Changes changes, DisplayMerchandise displayMerchandise, int inputAmount) {
        this.vendingMachine = new VendingMachine(changes, displayMerchandise, inputAmount);
    }
}
