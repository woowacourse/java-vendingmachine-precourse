package vendingmachine.controller;

import static vendingmachine.view.constant.InputMessage.REQUEST_VM_COIN;

import vendingmachine.exception.ExceptionHandler;
import vendingmachine.util.InputUtil;
import vendingmachine.util.Parser;
import vendingmachine.view.output.VendingMachineOutputWriter;

public class VendingMachineController {
    private VendingMachineController(){
    }

    public static void requestVendingMachineCoin() {
        VendingMachineOutputWriter.println(REQUEST_VM_COIN.getMessage());
        int coin = ExceptionHandler.retryOnBusinessException(VendingMachineController::createVMCoinFromInput);
    }

    private static int createVMCoinFromInput() {
        String dateInput = InputUtil.readLine();
        return Parser.parseVMCoinInput(dateInput);
    }
}
