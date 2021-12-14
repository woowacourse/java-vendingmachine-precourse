package vendingmachine.model;

public class VendingMachine {
    private static final int ZERO = 0;
    private static final String EXCEED_REST_AMOUNT_MESSAGE = "잔액을 초과하여 구매할 수 없습니다.";
    private static final String NOT_DIVIDED_INTO_SEMICOLON_MESSAGE = "상품 정보는 세미콜론으로 구분되어야 합니다.";
    private static final String TO_STRING_INPUT_AMOUNT_PREFIX = "투입 금액: ";
    private static final String WRONG_SEMICOLON = "][";
    private static final String AMOUNT_UNIT = "원";

    private final Products products;
    private final HoldingCoins holdingCoins;
    private int inputAmount = ZERO;

    public VendingMachine(String productsInfo, HoldingCoins holdingCoins) {
        validateDividedIntoSemicolon(productsInfo);
        this.products = new Products(productsInfo);
        this.holdingCoins = holdingCoins;
    }

    public void buy(String productName) {
        Product product = products.takeOut(productName);
        inputAmount = deductFromInputAmount(product.getPrice());
    }

    public void insertMoney(int inputAmount) {
        this.inputAmount = inputAmount;
    }

    public boolean isPurchasable() {
        return products.isPurchasable(inputAmount);
    }

    public String toStringChanges() {
        return new Change(inputAmount, holdingCoins).toString();
    }

    public String toStringInputAmount() {
        return new StringBuilder()
                .append(TO_STRING_INPUT_AMOUNT_PREFIX).append(inputAmount).append(AMOUNT_UNIT)
                .toString();
    }

    public boolean isRestQuantity(String productName, int productQuantity) {
        return products.findByName(productName).isRestQuantity(productQuantity);
    }

    private void validateDividedIntoSemicolon(String productsString) {
        if (isContainsWrongBrackets(productsString)) {
            throw new IllegalArgumentException(NOT_DIVIDED_INTO_SEMICOLON_MESSAGE);
        }
    }

    private boolean isContainsWrongBrackets(String productsString) {
        return productsString.contains(WRONG_SEMICOLON);
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