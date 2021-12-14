package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_HOLDING_AMOUNTS_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INPUT_PRODUCTS_INFO_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INPUT_INPUT_AMOUNT_MESSAGE = "투입 금액을 입력해 주세요.";
    private static final String INPUT_DEMAND_PRODUCT_NAME = "구매할 상품명을 입력해 주세요.";
    private static final String ERROR_NOT_NUMERIC_AMOUNT_INPUT_MESSAGE = "금액에는 정수를 입력해주세요.";

    public static int getHoldingAmount() {
        System.out.println(INPUT_HOLDING_AMOUNTS_MESSAGE);
        String holdingAmountString = Console.readLine();

        validateAmountIsNumeric(holdingAmountString);

        return Integer.parseInt(holdingAmountString);
    }

    public static String getProductsInfo() {
        System.out.println(INPUT_PRODUCTS_INFO_MESSAGE);
        return Console.readLine();
    }

    public static int getInputAmount() {
        System.out.println(INPUT_INPUT_AMOUNT_MESSAGE);
        String inputAmountString = Console.readLine();

        validateAmountIsNumeric(inputAmountString);

        return Integer.parseInt(inputAmountString);
    }

    public static String getDemandProductName() {
        System.out.println(INPUT_DEMAND_PRODUCT_NAME);
        return Console.readLine();
    }

    private static void validateAmountIsNumeric(String holdingAmountString) {
        if (!StringUtils.isNumeric(holdingAmountString)) {
            throw new IllegalArgumentException(ERROR_NOT_NUMERIC_AMOUNT_INPUT_MESSAGE);
        }
    }
}
