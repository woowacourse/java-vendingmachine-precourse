package vendingmachine.domain.VendingMachine;

public class Price {
    private final int price;

    public Price(int price) {
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        validateOverHundred(price);
        validateDivisibleByTen(price);
    }

    private void validateOverHundred(int price) {
        if (price < 100) {
            throw new IllegalArgumentException("[ERROR] 가격이 100원 미만입니다!");
        }
    }

    private void validateDivisibleByTen(int price) {
        if (price % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 10원으로 나누어지지 않습니다!");
        }
    }

    public boolean isAvailable(int money) {
        return price <= money;
    }

    public int getPrice() {
        return price;
    }
}
