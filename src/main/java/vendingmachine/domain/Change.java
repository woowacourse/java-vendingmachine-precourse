package vendingmachine.domain;

public class Change {
    private final Coin coin;
    private final int quantity;

    public Change(Coin coin, int quantity) {
        this.coin = coin;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return  coin.getAmount() + "원 - " + quantity + "개";
    }
}