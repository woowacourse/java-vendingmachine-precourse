package vendingmachine.controller;

import static vendingmachine.Constant.*;

import java.util.ArrayList;

import vendingmachine.service.VendingMachineService;
import vendingmachine.utils.StringUtil;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private boolean isContinue = true;
    private VendingMachineService vendingMachineService;

    public void start() {
        initializeByAdmin();
        useVendingMachine();
        vendingMachineService.giveChange();
    }

    private void useVendingMachine() {
        try {
            String userMoneyInput = InputView.inputUserMoney();
            vendingMachineService.putUserMoney(userMoneyInput);
            while (isContinue) {
                buyProduct();
            }
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            useVendingMachine();
        }
    }

    private void buyProduct() {
        try {
            String productName = inputBuyingProduct();
            if (!isContinue) {
                return;
            }
            vendingMachineService.sellProduct(productName);
            isContinue = vendingMachineService.isContinue();
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            buyProduct();
        }
    }

    private String inputBuyingProduct() {
        String productName = InputView.inputBuyingProduct();
        if (productName.equals(EXIT_CODE)) {
            isContinue = false;
        }
        return productName;
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
