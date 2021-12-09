package vendingmachine.controller;

import vendingmachine.domain.Asset;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private final InputView inputView;
    private final OutputView outputView;

    public VendingMachineController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        setupVendingMachine();
    }

    private void setupVendingMachine() {
        Asset asset = inputView.getInitialAsset();
    }
}
