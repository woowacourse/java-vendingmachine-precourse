package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String INPUT_VENDING_MACHINE_CHANGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    public static final String INPUT_BEVERAGE_INFO = "상품명과 가격, 수량을 입력해 주세요.";
    public static final String INPUT_INSERT_MONEY = "투입 금액을 입력해 주세요.";
    public static final String INPUT_BUY_BEVERAGE_NAME = "구매할 상품명을 입력해 주세요.";

    public static String insertVendingMachineChange() {
        System.out.println(INPUT_VENDING_MACHINE_CHANGE);
        return Console.readLine();
    }

    public static String insertBeverageInfo() {
        System.out.println(INPUT_BEVERAGE_INFO);
        return Console.readLine();
    }

    public static String insertInsertMoney() {
        System.out.println(INPUT_INSERT_MONEY);
        return Console.readLine();
    }

    public static String insertBuyBeverageName() {
        System.out.println(INPUT_BUY_BEVERAGE_NAME);
        return Console.readLine();
    }
}
