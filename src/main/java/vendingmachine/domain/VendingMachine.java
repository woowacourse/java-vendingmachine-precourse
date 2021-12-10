package vendingmachine.domain;

import java.util.ArrayList;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.utils.StringUtil;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachine {
    private boolean isOperate = true;
    private VendingMachineController vendingMachineController;

    public void start() {
        initializeByAdmin();
        useClient();
        vendingMachineController.giveChange();
    }

    private void useClient() {
        try {
            String userMoneyInput = InputView.inputUserMoney();
            vendingMachineController.putUserMoney(userMoneyInput);
            while (isOperate) {
                isOperate = vendingMachineController.sellProduct();
            }
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            useClient();
        }
    }

    private void initializeByAdmin() {
        makeCoinsUsingEnteredAmount();
        putProductInVendingMachine();
    }

    private void putProductInVendingMachine() {
        try {
            ArrayList<String> productsInfo = StringUtil.splitUsingSemiColon(InputView.inputProductsInfo());
            vendingMachineController.putProducts(productsInfo);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            putProductInVendingMachine();
        }
    }

    private void makeCoinsUsingEnteredAmount() {
        try {
            int initializeMoney = StringUtil.parseStringToInt(InputView.inputInitialAmount());
            vendingMachineController = VendingMachineController.makeVendingMachineHasMoney(initializeMoney);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            makeCoinsUsingEnteredAmount();
        }
    }
}
