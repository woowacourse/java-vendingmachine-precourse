package vendingmachine.View;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Constant.InputConstant;

public class InputView {
    public static String getHoldingAmount() {
        System.out.println(InputConstant.PLEASE_INPUT_HAVING_AMOUNT);
        return Console.readLine();
    }

    public static String getProductInfo() {
        System.out.println(InputConstant.PLEASE_INPUT_PRODUCTS);
        return Console.readLine();
    }

    public static String getInputAmount() {
        System.out.println(InputConstant.PLEASE_INPUT_INPUT_AMOUNT);
        return Console.readLine();
    }

    public static String getProductToPurchase() {
        System.out.println(InputConstant.PLEASE_INPUT_PRODUCT_TO_PURCHASE);
        return Console.readLine();
    }

    public static void inputOver() {
        System.out.println();
    }
}
