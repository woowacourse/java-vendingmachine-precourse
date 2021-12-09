package vendingmachine;

import java.util.ArrayList;

import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.StringUtil;
import vendingmachine.view.InputView;

public class Application {
    public static void main(String[] args) {
        boolean isOperate = true;

        int initializeMoney = StringUtil.parseStringToInt(InputView.inputInitialAmount());
        VendingMachine vendingMachine = VendingMachine.makeVendingMachineHasMoney(initializeMoney);
        //상품명들을 입력. -> VendingMachine의 ProductRepository
        ArrayList<String> productsInfo = StringUtil.splitUsingSemiColon(InputView.inputProductsInfo());
        vendingMachine.putProducts(productsInfo);
        String userMoneyInput = InputView.inputUserMoney();
        vendingMachine.putUserMoney(userMoneyInput);
        while (isOperate) {
            isOperate = vendingMachine.sellProduct();
        }
    }
}
