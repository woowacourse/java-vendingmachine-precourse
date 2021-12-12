package vendingmachine.View;

import vendingmachine.Constant.ErrorConstant;
import vendingmachine.Constant.OutputConstant;
import vendingmachine.Domain.Coins;
import vendingmachine.Domain.InputAmount;

public class OutputView {

    public static void printError(String message) {
        System.out.println(ErrorConstant.ERROR_OCCURRED + message);
    }

    public static void printInputAmount() {
        System.out.println(InputAmount.printInputAmount());
    }

    public static void printHoldingCoins() {
        System.out.println(OutputConstant.PRINT_COIN);
        System.out.println(Coins.printHoldingCoins());
    }

    public static void printChange() {
        System.out.println(OutputConstant.PRINT_CHANGE);
        System.out.println(Coins.printChange());
    }

}
