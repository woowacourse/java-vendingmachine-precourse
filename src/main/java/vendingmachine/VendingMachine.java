package vendingmachine;

import java.util.Map;

public class VendingMachine {
    private static final int ZERO = 0;
    private static final String EXCEED_REST_AMOUNT_MESSAGE = "잔액을 초과하여 구매할 수 없습니다.";
    private static final String NOT_DIVIDED_INTO_SEMICOLON_MESSAGE = "상품 정보는 세미콜론으로 구분되어야 합니다.";
    private static final String TO_STRING_INPUT_AMOUNT_PREFIX = "투입금액: ";
    private static final String WRONG_SEMICOLON = "][";
    private static final String AMOUNT_UNIT = "원";

    private final Products products;
    private final Coins holdingCoins;
    private int inputAmount = ZERO;

    public VendingMachine(String productsString, int holdingMoney) {
        validateDividedIntoSemicolon(productsString);
        this.products = new Products(productsString);
        this.holdingCoins = new Coins(holdingMoney);
    }

    public String toStringHoldingCoins() {
        return holdingCoins.toString();
    }

    public String  toStringInputAmount() {
        return TO_STRING_INPUT_AMOUNT_PREFIX + inputAmount + AMOUNT_UNIT;
    }

    private void validateDividedIntoSemicolon(String productsString) {
        if (isContainsWrongBrackets(productsString)) {
            throw new IllegalArgumentException(NOT_DIVIDED_INTO_SEMICOLON_MESSAGE);
        }
    }

    private boolean isContainsWrongBrackets(String productsString) {
        return productsString.contains(WRONG_SEMICOLON);
    }

    public void buy(String productName, int productQuantity) {
        int totalPrice = products.takeOut(productName, productQuantity);
        inputAmount = deductFromInputAmount(totalPrice);
    }

    public void insertMoney(int inputAmount) {
        this.inputAmount = inputAmount;
    }

    public boolean isPurchasable() {
        return products.isPurchasable(inputAmount);
    }

    private void validatePurchasable(int restAmount) {
        if (isExceedRestAmount(restAmount)) {
            throw new IllegalArgumentException(EXCEED_REST_AMOUNT_MESSAGE);
        }
    }

    private boolean isExceedRestAmount(int restAmount) {
        return restAmount < ZERO;
    }

    private int deductFromInputAmount(int totalPrice) {
        int restAmount = inputAmount - totalPrice;
        validatePurchasable(restAmount);

        return restAmount;
    }

}