package vendingmachine.domain;

public class InputAmount {

    private int amount;

    public InputAmount(int inputAmount) {
        this.amount = inputAmount;
    }

    public int getAmount() {
        return amount;
    }

    public void consume(int price) {
        amount -= price;
    }
}
