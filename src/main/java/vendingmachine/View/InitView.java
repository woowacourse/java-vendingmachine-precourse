package vendingmachine.View;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Constant.InputConstant;

public class InitView {
    public static String getHoldingAmount() {
        System.out.println(InputConstant.PLEASE_INPUT_HAVING_AMOUNT);
        return Console.readLine();
    }
}
