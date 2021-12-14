package vendingmachine.controller;

import vendingmachine.service.BuyService;
import vendingmachine.service.ChangeService;
import vendingmachine.service.MachineCoinService;
import vendingmachine.service.ProductService;

import static vendingmachine.view.InputViews.inputOrderMessage;
import static vendingmachine.view.OutputViews.*;

public class VendingMachineController {
    private static ChangeService changeService;
    private static ProductService productService;
    private static MachineCoinService machineCoinService;
    private static BuyService buyService;

    public void init() {
        machineCoinService = new MachineCoinService();
        productService = new ProductService();
        changeService = new ChangeService();
        buyService = new BuyService();

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

    public void startSale() {
        int currentChange = changeService.getCurrentChange();
        while (buyService.isAvailableKeepSell(currentChange)) {
            buyService.sellProduct(getUserOrder(currentChange));
            currentChange = changeService.getCurrentChange();
        }
        printCurrentChange(changeService.getCurrentChange());
        printFinalChange(changeService.getFinalChange());
    }

    private String getUserOrder(int change) {
        while (true) {
            try {
                printCurrentChange(change);
                String order = inputOrderMessage();
                buyService.isValidOrderName(order, change);
                return order;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }
}
