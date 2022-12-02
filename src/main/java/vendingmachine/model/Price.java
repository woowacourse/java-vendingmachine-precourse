package vendingmachine.model;

public class Price {
    private int price;

    Price(String price) {
        try {
            this.price = Integer.parseInt(price);
            validate(this.price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("가격은 숫자여야 합니다.");
        }
    }

    public int get() {
        return price;
    }

    private void validate(int price) {
        if (price < 100) {
            throw new IllegalArgumentException("가격은 100원 이상이어야 합니다.");
        }
        if (price % 10 != 0) {
            throw new IllegalArgumentException("가격은 10원으로 나누어떨어져야 합니다.");
        }
    }
}
