package vendingmachine.domain.machine;

public class VendingMachine {
    private int balance;

    public VendingMachine(int balance) {
        this.balance = balance;
    }

    // for test
    public boolean isEqualBalance(int balance) {
        return this.balance == balance;
    }
}
