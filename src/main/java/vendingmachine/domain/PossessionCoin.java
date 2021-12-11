package vendingmachine.domain;

public class PossessionCoin {
    private final Coin coin;
    private final int quantity;

    public PossessionCoin(Coin coin, int quantity) {
        this.coin = coin;
        this.quantity = quantity;
    }
}