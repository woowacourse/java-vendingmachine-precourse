package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.StringUtils;

public class InputView {
    private static final String INPUT_HOLDING_AMOUNTS_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INPUT_PRODUCTS_INFO_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INPUT_INPUT_AMOUNT_MESSAGE = "투입 금액을 입력해 주세요.";
    private static final String INPUT_DEMAND_PRODUCT_NAME = "구매할 상품명을 입력해 주세요.";
    private static final String ERROR_NOT_NUMERIC_AMOUNT_INPUT_MESSAGE = "금액에는 정수를 입력해주세요.";
    private static final String ERROR_EMPTY_INPUT_MESSAGE = "값을 입력해주세요.";

    public static int getHoldingAmount() {
        System.out.println(INPUT_HOLDING_AMOUNTS_MESSAGE);
        String holdingAmountString = Console.readLine();

        validateIsNotNull(holdingAmountString);
        validateAmountIsNumeric(holdingAmountString);

        return Integer.parseInt(holdingAmountString);
    }

    public static String getProductsInfo() {
        System.out.println(INPUT_PRODUCTS_INFO_MESSAGE);
        String productsInfo = Console.readLine();

        validateIsNotNull(productsInfo);

        return productsInfo;
    }

    public static int getInputAmount() {
        System.out.println(INPUT_INPUT_AMOUNT_MESSAGE);
        String inputAmountString = Console.readLine();

        validateIsNotNull(inputAmountString);
        validateAmountIsNumeric(inputAmountString);

        return Integer.parseInt(inputAmountString);
    }

    public static String getDemandProductName() {
        System.out.println(INPUT_DEMAND_PRODUCT_NAME);
        String productName = Console.readLine();

        validateIsNotNull(productName);

        return productName;
    }

    private static void validateIsNotNull(String input) {
        if (StringUtils.isEmpty(input)) {
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT_MESSAGE);
        }
    }

    private static void validateAmountIsNumeric(String holdingAmountString) {
        if (!StringUtils.isNumeric(holdingAmountString)) {
            throw new IllegalArgumentException(ERROR_NOT_NUMERIC_AMOUNT_INPUT_MESSAGE);
        }
    }
}
