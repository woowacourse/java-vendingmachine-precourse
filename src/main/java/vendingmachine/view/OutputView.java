package vendingmachine.view;

import static vendingmachine.constants.Message.ASK_BUY_PRODUCT_NAME;
import static vendingmachine.constants.Message.MONEY_STATUS;

public class OutputView {
    public void printAskProductName() {
        System.out.println(ASK_BUY_PRODUCT_NAME.getMessage());
    }


    public void printCurrentAmount(int currentAmount) {
        System.out.printf(MONEY_STATUS.getMessage(), currentAmount);
        System.out.println();
    }
}
