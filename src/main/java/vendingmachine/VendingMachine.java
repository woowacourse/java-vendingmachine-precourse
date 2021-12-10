package vendingmachine;

public class VendingMachine {
    public Coins currentBalance;

    public void depositCurrentBalance(Coins currentBalance) {
        this.currentBalance = currentBalance;
    }
}
