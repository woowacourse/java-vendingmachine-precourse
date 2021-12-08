package vendingmachine.domain;

class Money {
    private int price;

    public Money(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int reducePrice(int paidMoney) {
        price -= paidMoney;
        return price;
    }
}
