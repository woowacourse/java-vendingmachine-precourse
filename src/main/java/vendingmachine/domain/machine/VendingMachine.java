package vendingmachine.domain.machine;

public class VendingMachine {
    private int balance;

    public static VendingMachine of(int balance) {
        return new VendingMachine(balance);
    }
    private VendingMachine(int balance) {
        this.balance = balance;
    }

    // for test
    public boolean isEqualBalance(int balance) {
        return this.balance == balance;
    }
}
