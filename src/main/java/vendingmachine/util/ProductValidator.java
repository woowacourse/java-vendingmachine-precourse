package vendingmachine.util;

import vendingmachine.model.VendingMachine;

public class ProductValidator {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String RETRY_MESSAGE = " 다시 입력해주세요.";
    private static final String PRODUCT_NOT_EXIST = "존재하지 않는 상품명입니다";

    public static void validateProduct(VendingMachine vendingMachine, String input) {
        if(!vendingMachine.hasProduct(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + PRODUCT_NOT_EXIST + RETRY_MESSAGE);
        }
    }
}
