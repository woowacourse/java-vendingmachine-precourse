package vendingmachine.controller;

import vendingmachine.service.ChangeService;
import vendingmachine.service.MachineCoinService;
import vendingmachine.service.ProductService;

import static vendingmachine.view.InputViews.inputOrderMessage;
import static vendingmachine.view.OutputViews.*;

public class VendingMachineController {

    private static ChangeService changeService;
    private static ProductService productService;
    private static MachineCoinService machineCoinService;

    public void init() {
        machineCoinService = new MachineCoinService();
        productService = new ProductService();
        changeService = new ChangeService();

        initMachineCoin();
        initProductList();
        initUserChange();
    }

    private void initMachineCoin() {
        int inputMoney = machineCoinService.getInitMachineMoney();
        machineCoinService.initRemainCoin(inputMoney);
        printMachineInitCoin(machineCoinService.getNumOfCoin());
    }

    private void initProductList() {
        productService.getProductList();
    }

    private void initUserChange() {
        changeService.getInitUserChange();
    }

    public void orderProduct() {
        printCurrentChange(changeService.getCurrentChange());
        inputOrderMessage();
    }
}
