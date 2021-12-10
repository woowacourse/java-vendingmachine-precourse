package vendingmachine.controller;

import java.util.ArrayList;

import vendingmachine.service.VendingMachineService;
import vendingmachine.utils.StringUtil;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private boolean isOperate = true;
    private VendingMachineService vendingMachineService;

    public void start() {
        initializeByAdmin();
        useClient();
        vendingMachineService.giveChange();
    }

    private void useClient() {
        try {
            String userMoneyInput = InputView.inputUserMoney();
            vendingMachineService.putUserMoney(userMoneyInput);
            while (isOperate) {
                buyProduct();
            }
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            useClient();
        }
    }

    private void buyProduct() {
        try {
            String productName = InputView.inputBuyingProduct();
            isOperate = vendingMachineService.sellProduct(productName);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            buyProduct();
        }
    }

    private void initializeByAdmin() {
        makeCoinsUsingEnteredAmount();
        putProductInVendingMachine();
    }

    private void putProductInVendingMachine() {
        try {
            ArrayList<String> productsInfo = StringUtil.splitUsingSemiColon(InputView.inputProductsInfo());
            vendingMachineService.putProducts(productsInfo);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            putProductInVendingMachine();
        }
    }

    private void makeCoinsUsingEnteredAmount() {
        try {
            int initializeMoney = StringUtil.parseStringToInt(InputView.inputInitialAmount());
            vendingMachineService = VendingMachineService.makeVendingMachineHasMoney(initializeMoney);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            makeCoinsUsingEnteredAmount();
        }
    }
}
