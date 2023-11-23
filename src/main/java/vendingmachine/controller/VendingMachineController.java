package vendingmachine.controller;

import static vendingmachine.view.InputView.*;
import static vendingmachine.view.constant.InputMessage.REQUEST_VM_COIN;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private VendingMachineController(){
    }

    public static void requestVendingMachineCoin() {
        OutputView.println(REQUEST_VM_COIN.getMessage());
        int coin = readVendingMachineCoinInfo();
    }
}
