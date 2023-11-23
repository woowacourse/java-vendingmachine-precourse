package vendingmachine.controller;

import static vendingmachine.util.CoinGenerator.vendingMachineCoinGeneration;
import static vendingmachine.view.constant.InputMessage.*;

import java.util.EnumMap;
import java.util.Map;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.constant.Coin;
import vendingmachine.domain.constant.Product;
import vendingmachine.exception.ExceptionHandler;
import vendingmachine.util.InputUtil;
import vendingmachine.util.Parser;
import vendingmachine.view.output.OutputView;

public class VendingMachineController {
    private static EnumMap<Coin, Integer> vmCoinMap;
    private static Map<String, Product> productMap;
    private VendingMachineController(){
    }

    public static VendingMachine requestVendingMachine(){
        requestVendingMachineCoin();
        requestVendingMachineProducts();
        return VendingMachine.from(vmCoinMap,productMap);
    }

    private static void requestVendingMachineCoin() {
        OutputView.println(REQUEST_VM_COIN.getMessage());
        vmCoinMap = ExceptionHandler.retryOnBusinessException(VendingMachineController::createVMCoinFromInput);
        OutputView.printCoinMap(vmCoinMap);
    }

    private static void requestVendingMachineProducts() {
        OutputView.println(REQUEST_VM_PRODUCT.getMessage());
        productMap = ExceptionHandler.retryOnBusinessException(VendingMachineController::createVMProductFromInput);
    }

    private static EnumMap<Coin, Integer> createVMCoinFromInput() {
        String coin = InputUtil.readLine();
        int coinInput =  Parser.parseMoneyInput(coin);
        return vendingMachineCoinGeneration(coinInput);
    }

    private static Map<String, Product> createVMProductFromInput() {
        String products = InputUtil.readLine();
        return  Parser.parseVMProductsInput(products);
    }

}
