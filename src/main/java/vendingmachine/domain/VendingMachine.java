package vendingmachine.domain;

import java.util.ArrayList;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.utils.StringUtil;
import vendingmachine.view.InputView;

public class VendingMachine {
    private boolean isOperate = true;
    private VendingMachineController vendingMachineController;

    public void start() {
        initializeByAdmin();
        useClient();
        vendingMachineController.giveChange();
    }

    private void useClient() {
        String userMoneyInput = InputView.inputUserMoney();
        vendingMachineController.putUserMoney(userMoneyInput);
        while (isOperate) {
            isOperate = vendingMachineController.sellProduct();
        }
    }

    private void initializeByAdmin() {
        int initializeMoney = StringUtil.parseStringToInt(InputView.inputInitialAmount());
        vendingMachineController = VendingMachineController.makeVendingMachineHasMoney(initializeMoney);
        ArrayList<String> productsInfo = StringUtil.splitUsingSemiColon(InputView.inputProductsInfo());
        vendingMachineController.putProducts(productsInfo);
    }
}
