package vendingmachine.controller;

import vendingmachine.model.Asset;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private Asset asset;

    public void start() {
        setupVendingMachine();
        OutputView.showCoins(asset.showCoins());
    }

    private void setupVendingMachine() {
        this.asset = InputView.getInitialAsset();
        asset.generateRandomCoins();
    }
}
