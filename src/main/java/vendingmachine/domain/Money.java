package vendingmachine.domain;

public class Money {

    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public void reduceAmount(int itemPrice) {
        amount -= itemPrice;
    }

    public boolean isBiggerOrEqual(int minPrice) {
        return amount >= minPrice;
    }

    public int getAmount() {
        return amount;
    }
}
