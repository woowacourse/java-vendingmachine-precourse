package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String REQUIRE_CHANGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String SET_MERCHANDISE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String REQUIRE_MONEY = "투입 금액을 입력해 주세요.";
    private static final String REQUIRE_MERCHANDIES = "구매할 상품명을 입력해 주세요.";

    public static String requireChanges() {
        System.out.println(REQUIRE_CHANGE);
        return Console.readLine();
    }

    public static String requireVendingMachineMerchandiseInfo() {
        System.out.println(SET_MERCHANDISE);
        return Console.readLine();
    }

    public static String requireMoney() {
        System.out.println(REQUIRE_MONEY);
        return Console.readLine();
    }

    public static String requireMerchandise() {
        System.out.println(REQUIRE_MERCHANDIES);
        return Console.readLine();
    }
}
