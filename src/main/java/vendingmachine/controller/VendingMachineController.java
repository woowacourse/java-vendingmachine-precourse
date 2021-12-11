package vendingmachine.controller;

import static vendingmachine.Constant.*;

import java.util.ArrayList;

import vendingmachine.domain.VendingMachineChecker;
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
            buyProductsUntilEnd(VendingMachineChecker.START);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            useVendingMachine();
        }
    }

    private VendingMachineChecker buyProductsUntilEnd(VendingMachineChecker checker) {
        while (checker == VendingMachineChecker.START) {
            String productName = InputView.inputBuyingProduct();
            try {
                checker = vendingMachineService.sellProduct(productName);
            } catch (IllegalArgumentException e) {
                return checkShutDown(checker, productName, e);
            }
        }
        return checker;
    }

    private VendingMachineChecker checkShutDown(VendingMachineChecker checker, String productName,
        IllegalArgumentException e) {
        if (productName.equals(EXIT_CODE)) {
            return buyProductsUntilEnd(VendingMachineChecker.END);
        }
        OutputView.showErrorMessage(e);
        return buyProductsUntilEnd(checker);
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
