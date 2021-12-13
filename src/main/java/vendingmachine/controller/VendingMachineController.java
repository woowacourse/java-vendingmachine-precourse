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

    public void startSale() {
        int currentChange = ChangeService.getCurrentChange();
        while (isAvailableKeepSell(currentChange)) {
            getUserOrder(currentChange);
        }
    }

    private boolean isAvailableKeepSell(int change) {
        if (!productService.availableToBuy(change)) {
            return false;
        }
        return true;
    }

    private String getUserOrder(int change) {
        while (true) {
            try {
                printCurrentChange(change);
                String order = inputOrderMessage();
                ProductService.isValidOrderName(order, change);
                return order;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
