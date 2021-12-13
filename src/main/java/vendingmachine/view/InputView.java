package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getMoney() {
        return Console.readLine();
    }

    public static String getProduct() {
        return Console.readLine();
    }

    public static String getOrder() {
        return Console.readLine();
    }

}
