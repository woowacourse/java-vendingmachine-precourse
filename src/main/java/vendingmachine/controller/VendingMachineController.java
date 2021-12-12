package vendingmachine.controller;

import vendingmachine.service.VendingMachineService;
import vendingmachine.view.VendingMachineInputView;
import vendingmachine.view.VendingMachineOutputView;

public class VendingMachineController {
    private final VendingMachineService vendingMachineService;
    private final VendingMachineInputView vendingMachineInputView;
    private final VendingMachineOutputView vendingMachineOutputView;

    public VendingMachineController() {
        this.vendingMachineService = new VendingMachineService();
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
    }

    public void turnOnVendingMachine() {
        // TODO: 자판기 판매 시작
    }

    public void turnOffVendingMachine() {
        // TODO: 자판기 판매 종료, 잔돈 반환
    }
}
