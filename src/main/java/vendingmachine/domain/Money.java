package vendingmachine.domain;

public class Money {

    private int price;

    public Money(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void reduce(int money) {
        price = price - money;
    }
}
