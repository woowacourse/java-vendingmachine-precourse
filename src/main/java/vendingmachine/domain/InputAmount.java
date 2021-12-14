package vendingmachine.domain;

public class InputAmount {

    private static final String ERR_INVALID_AMOUNT = "[ERROR] 투입금액은 0원 이상이어야합니다.";
    private static final String LOCAL_CURRENCY_UNIT = "원";
    private static final int MIN_AMOUNT = 1;
    private static final int ZERO = 0;

    private int amount;

    public InputAmount(int inputAmount) {
        validateInputAmount(inputAmount);
        this.amount = inputAmount;
    }

    public int getAmount() {
        return amount;
    }

    public void clearAmount() {
        this.amount = ZERO;
    }

    public void buy(Product product) {
        amount -= product.getAmount();
    }

    public String getLocalCurrency() {
        return String.join("", String.valueOf(amount), LOCAL_CURRENCY_UNIT);
    }

    private void validateInputAmount(int inputAmount) {
        if (inputAmount < MIN_AMOUNT) {
            throw new IllegalArgumentException(ERR_INVALID_AMOUNT);
        }
    }
}
