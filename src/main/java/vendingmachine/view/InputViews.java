package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputViews {
    public static final String INPUT_INIT_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    public static final String INPUT_PRODUCT_LIST_MESSAGE = "\n상품명과 가격, 수량을 입력해 주세요.";
    public static final String INPUT_USER_MONEY_MESSAGE = "\n투입 금액을 입력해 주세요.";
    public static final String INPUT_PRODUCT_NAME = "구매할 상품명을 입력해 주세요.";

    public static String inputInitMachineMoney() {
        System.out.println(INPUT_INIT_MONEY_MESSAGE);
        return Console.readLine();
    }

    public static String inputProductList() {
        System.out.println(INPUT_PRODUCT_LIST_MESSAGE);
        return Console.readLine();
    }

    public static String inputUserMoney() {
        System.out.println(INPUT_USER_MONEY_MESSAGE);
        return Console.readLine();
    }

    public static String inputOrderMessage() {
        System.out.println(INPUT_PRODUCT_NAME);
        return Console.readLine();
    }
}
