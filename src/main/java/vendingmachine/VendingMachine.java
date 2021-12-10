package vendingmachine;

public class VendingMachine {
    private Coins currentBalance;

    public Coins depositCurrentBalance(Coins currentBalance) {
        this.currentBalance = currentBalance;
        return this.currentBalance;
    }
}
