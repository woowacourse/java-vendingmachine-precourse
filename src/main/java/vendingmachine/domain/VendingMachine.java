package vendingmachine.domain;

public class VendingMachine {

    private final Money money;
    private final Coins coins;

    private VendingMachine(Money money, Coins coins) {
        this.money = money;
        this.coins = coins;
    }
}
