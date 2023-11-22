package vendingmachine.view;

import static vendingmachine.constants.Message.ASK_BUY_PRODUCT_NAME;
import static vendingmachine.constants.Message.ASK_INPUT_AMOUNT;
import static vendingmachine.constants.Message.ASK_PRODUCT_INFO;
import static vendingmachine.constants.Message.MONEY_STATUS;

public class OutputView {
    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printAskProductName() {
        System.out.println(ASK_BUY_PRODUCT_NAME.getMessage());
    }

    public void printCurrentAmount(int currentAmount) {
        System.out.printf(MONEY_STATUS.getMessage(), currentAmount);
        System.out.println();
    }

    public void printAskInputAmount() {
        System.out.println(ASK_INPUT_AMOUNT.getMessage());
    }

    public void printAskStockInfo() {
        System.out.println(ASK_PRODUCT_INFO.getMessage());
    }
}
