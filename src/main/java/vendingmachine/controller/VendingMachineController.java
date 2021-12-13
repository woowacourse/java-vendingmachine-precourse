package vendingmachine.controller;

import vendingmachine.model.Changes;
import vendingmachine.service.ChangesService;
import vendingmachine.service.VendingMachineService;
import vendingmachine.view.VendingMachineInputView;
import vendingmachine.view.VendingMachineOutputView;

public class VendingMachineController {
    private final VendingMachineService vendingMachineService;
    private final ChangesService changesService;
    private final VendingMachineInputView vendingMachineInputView;
    private final VendingMachineOutputView vendingMachineOutputView;

    public VendingMachineController() {
        this.vendingMachineService = new VendingMachineService();
        this.changesService = new ChangesService();
        this.vendingMachineInputView = new VendingMachineInputView();
        this.vendingMachineOutputView = new VendingMachineOutputView();
    }

    public void run() {
        setVendingMachine();
        turnOnVendingMachine();
        turnOffVendingMachine();
    }

    public void setVendingMachine() {
        // TODO: 자판기 세팅
        int amount = vendingMachineInputView.inputHoldingAmount();
        Changes changes = changesService.createChanges(amount);
        vendingMachineOutputView.outputHoldingChanges(changesService.getHoldingChanges(changes));
        String[][] merchandise = vendingMachineInputView.inputMerchandiseInfo();
    }

    public void turnOnVendingMachine() {
        // TODO: 자판기 판매 시작
    }

    public void turnOffVendingMachine() {
        // TODO: 자판기 판매 종료, 잔돈 반환
    }
}
