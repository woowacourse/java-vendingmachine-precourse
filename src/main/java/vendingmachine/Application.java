package vendingmachine;

import java.util.ArrayList;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.utils.StringUtil;
import vendingmachine.view.InputView;

public class Application {
    public static void main(String[] args) {
        boolean isOperate = true;

        int initializeMoney = StringUtil.parseStringToInt(InputView.inputInitialAmount());
        VendingMachineController vendingMachineController = VendingMachineController.makeVendingMachineHasMoney(initializeMoney);
        //상품명들을 입력. -> VendingMachine의 ProductRepository
        ArrayList<String> productsInfo = StringUtil.splitUsingSemiColon(InputView.inputProductsInfo());
        vendingMachineController.putProducts(productsInfo);
        String userMoneyInput = InputView.inputUserMoney();
        vendingMachineController.putUserMoney(userMoneyInput);
        while (isOperate) {
            isOperate = vendingMachineController.sellProduct();
        }
        vendingMachineController.giveChange();
    }
}
