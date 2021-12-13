package vendingmachine;

public class Change {
    private int amount;

    Change(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void decreaseAmount(int input) {
        amount -= input;
    }
}
