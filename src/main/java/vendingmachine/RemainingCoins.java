package vendingmachine;

public class RemainingCoins {
    private final Money money;

    public RemainingCoins(String input) {
        money = new Money(input);
    }

    public Money getMoney() {
        return money;
    }
}
