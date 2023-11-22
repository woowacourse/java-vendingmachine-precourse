package vendingmachine.domain;

public class InsertedAmount {
    private long amount;

    private InsertedAmount(long amount) {
        this.amount = amount;
    }

    public static InsertedAmount from(long amount) {
        return new InsertedAmount(amount);
    }

    public long provideAmount() {
        return amount;
    }

    public void updateAmount(long amount) {
        this.amount = amount;
    }


    public boolean isEqualOrLargerThan(long amount) {
        return this.amount >= amount;
    }
}
