package vendingmachine.domain;

public class InputAmount {

    private int amount;

    private InputAmount(int amount) {
        this.amount = amount;
    }

    public void decrease(int amount) {
        this.amount -= amount;
    }
}
