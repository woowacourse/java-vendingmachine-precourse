package vendingmachine.View;

import vendingmachine.Constant.ErrorConstant;

public class ErrorOutputView {
    public static void printError(String message) {
        System.out.println(ErrorConstant.ERROR_OCCURRED + message);
    }
}
