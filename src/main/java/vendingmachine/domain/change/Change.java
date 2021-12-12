package vendingmachine.domain.change;

import vendingmachine.domain.Coin;

public class Change {
    private static final String TO_STRING_FORMAT = "%d원 - %d개";

    private final Coin coin;
    private final int quantity;

    public Change(Coin coin, int quantity) {
        this.coin = coin;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT, coin.getAmount(), quantity);
    }
}