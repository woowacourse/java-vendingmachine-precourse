package vendingmachine.controller;

import static vendingmachine.Constant.*;

import java.util.ArrayList;

import vendingmachine.service.VendingMachineService;
import vendingmachine.utils.StringUtil;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private VendingMachineService vendingMachineService;

    public VendingMachineController(VendingMachineService vendingMachineService) {
        this.vendingMachineService = vendingMachineService;
    }

    public void start() {
        initializeByAdmin();
        useVendingMachine();
        vendingMachineService.giveChange();
    }

    private void useVendingMachine() {
        try {
            String userMoneyInput = InputView.inputUserMoney();
            vendingMachineService.putUserMoney(userMoneyInput);
            buyProductsUntilEnd();
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            useVendingMachine();
        }
    }

    private void buyProductsUntilEnd() {
        do {
            String productName = InputView.inputBuyingProduct();
            System.out.println(productName);
            System.out.println(productName.equals(EXIT_CODE));
            if (productName.equals(EXIT_CODE)) {
                return;
            }
            buyProduct(productName);
        } while (vendingMachineService.isContinue());
    }

    private void buyProduct(String productName) {
        try {
            vendingMachineService.sellProduct(productName);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            buyProductsUntilEnd();
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
            vendingMachineService.putInitialAmount(initializeMoney);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            makeCoinsUsingEnteredAmount();
        }
    }
}
