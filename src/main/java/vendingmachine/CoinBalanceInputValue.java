package vendingmachine;

public class CoinBalanceInputValue {
    public final String input;

    public CoinBalanceInputValue(String input) {
        this.input = input;
    }

    public int toCoinBalance() {
        return Integer.parseInt(input);
    }
}
