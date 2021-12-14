package vendingmachine.domain;

public class Change {
    private static Change instance = null;
    private static int amount;

    public static Change getInstance() {
        if (instance == null) {
            instance = new Change(amount);
        }
        return instance;
    }

    public Change(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void calculateAmount(int input) {
        amount -= input;
    }
}
