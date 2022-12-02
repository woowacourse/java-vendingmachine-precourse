package vendingmachine.model;

public class Product {
    public Price price;
    public int amount;

    public Product(String price, String amount) throws IllegalArgumentException {
        this.price = new Price(price);
        try {
            this.amount = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("수량은 숫자여야 합니다.");
        }
        if (this.amount < 0) {
            throw new IllegalArgumentException("수량은 음수가 아닙니다.");
        }
    }
}
