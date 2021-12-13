package vendingmachine.service;

import vendingmachine.model.Changes;
import vendingmachine.model.DisplayMerchandise;
import vendingmachine.model.Merchandise;
import vendingmachine.model.VendingMachine;

public class VendingMachineService {
    private VendingMachine vendingMachine;

    public void createVendingMachine(Changes changes, DisplayMerchandise displayMerchandise, int inputAmount) {
        this.vendingMachine = new VendingMachine(changes, displayMerchandise, inputAmount);
    }

    public boolean canBuyWithRemainAmount() {
        int minPrice = vendingMachine.getDisplayMerchandise().getMinPriceMerchandise();
        int remainAmount = vendingMachine.getInputAmount();
        return remainAmount >= minPrice;
    }

    public int getRemainAmount() {
        return vendingMachine.getInputAmount();
    }

    public void buyMerchandise(String merchandiseName) {
        Merchandise merchandise = vendingMachine.getDisplayMerchandise().decreaseMerchandiseInventory(merchandiseName);
        vendingMachine.subtractInputAmount(merchandise.getPrice());
    }
}
