package vendingmachine.domain;

import static vendingmachine.Constant.*;

public class Price {
    private int price;

    public Price(String priceInput) {
        this.price = validate(priceInput);
    }

    public int validate(String priceInput) {
        int price = validateItIsNumber(priceInput);
        validateItIsPositive(price);
        validateUnitIsCorrect(price);
        return price;
    }

    private void validateUnitIsCorrect(int price) {
        if (price % MINIMUM_COIN_VALUE != 0) {
            throw new IllegalArgumentException("해당 금액은 동전으로 만들 수 없는 단위의 숫자입니다.");
        }
    }

    private void validateItIsPositive(int price) {
        if (price < ZERO) {
            throw new IllegalArgumentException("0 이상의 금액을 입력해주세요.");
        }
    }

    private int validateItIsNumber(String priceInput) {
        if (!priceInput.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("금액은 숫자여야 합니다.");
        }
        return Integer.parseInt(priceInput);
    }

    public int getPrice() {
        return price;
    }

    public void use(int productPrice) {
        this.price -= productPrice;
    }

    @Override
    public String toString() {
        return Integer.toString(price);
    }

}
