package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_HOLDING_AMOUNTS_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INPUT_PRODUCTS_INFO_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INPUT_INPUT_AMOUNT_MESSAGE = "투입 금액을 입력해 주세요.";
    private static final String INPUT_DEMAND_PRODUCT_NAME = "구매할 상품명을 입력해 주세요.";

    public static String getHoldingAmount() {
        System.out.println(INPUT_HOLDING_AMOUNTS_MESSAGE);
        return Console.readLine();
    }

    public static String getProductsInfo() {
        System.out.println(INPUT_PRODUCTS_INFO_MESSAGE);
        return Console.readLine();
    }

    public static String getInputAmount() {
        System.out.println(INPUT_INPUT_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public static String getDemandProductName() {
        System.out.println(INPUT_DEMAND_PRODUCT_NAME);
        return Console.readLine();
    }
}
