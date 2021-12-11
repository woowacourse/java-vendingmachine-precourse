package vendingmachine.domain;

public class PossessionCoin {
    private final Coin coin;
    private final int quantity;

    public PossessionCoin(Coin coin, int quantity) {
        this.coin = coin;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return coin.getAmount() + "원 - " + quantity + "개";
    }
}