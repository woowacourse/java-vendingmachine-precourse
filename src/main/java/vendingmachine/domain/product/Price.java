package vendingmachine.domain.product;

public class Price {
    private static final int DEFAULT_PRICE = 100;
    private static final int PRICE_QUOTIENT = 10;
    private static final int REMAINDER = 0;

    private final int price;

    public Price(String inputPrice) {
        validateNumberFormat(inputPrice);
        int price = Integer.parseInt(inputPrice);

        validateNumberSize(price);
        validateDivide(price);
        this.price = price;
    }

    private void validateNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberSize(int price) {
        if (price < DEFAULT_PRICE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDivide(int price) {
        if (price % PRICE_QUOTIENT != REMAINDER) {
            throw new IllegalArgumentException();
        }
    }

    protected int getPrice() {
        return price;
    }
}