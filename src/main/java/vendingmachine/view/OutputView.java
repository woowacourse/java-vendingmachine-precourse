package vendingmachine.view;

import static vendingmachine.view.constants.ErrorMessage.ERROR_TAG;
import static vendingmachine.view.constants.OutputMessage.ASK_TOTAL_MONEY_OF_VENDING_MACHINE;

public class OutputView {
    public static void askMachineTotalMoney(){
        print(ASK_TOTAL_MONEY_OF_VENDING_MACHINE);
    }

    private static void print(String message){
        System.out.println(message);
    }

    public static void errorMessage(String errorMessage) {
        System.out.println(ERROR_TAG + errorMessage);
    }
}
