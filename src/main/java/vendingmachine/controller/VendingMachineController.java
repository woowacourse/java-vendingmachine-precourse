package vendingmachine.controller;

import static vendingmachine.util.CoinGenerator.vendingMachineCoinGeneration;
import static vendingmachine.view.constant.InputMessage.REQUEST_VM_COIN;

import java.util.EnumMap;
import vendingmachine.domain.constant.Coin;
import vendingmachine.exception.ExceptionHandler;
import vendingmachine.util.InputUtil;
import vendingmachine.util.Parser;
import vendingmachine.view.output.VendingMachineOutputWriter;

public class VendingMachineController {
    private static EnumMap<Coin, Integer> vmCoinMap;
    private VendingMachineController(){
    }

    public static void requestVendingMachineCoin() {
        VendingMachineOutputWriter.println(REQUEST_VM_COIN.getMessage());
        vmCoinMap = ExceptionHandler.retryOnBusinessException(VendingMachineController::createVMCoinFromInput);
        VendingMachineOutputWriter.printCoinMap(vmCoinMap);
    }

    private static EnumMap<Coin, Integer> createVMCoinFromInput() {
        String coin = InputUtil.readLine();
        int coinInput =  Parser.parseVMCoinInput(coin);
        return vendingMachineCoinGeneration(coinInput);
    }

}
