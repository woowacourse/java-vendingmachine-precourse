package vendingmachine.controller;

import vendingmachine.model.Asset;
import vendingmachine.view.InputView;

public class VendingMachineController {

    private Asset asset;

    public void start() {
        setupVendingMachine();
    }

    private void setupVendingMachine() {
        this.asset = InputView.getInitialAsset();
        asset.generateRandomCoins();
    }
}
