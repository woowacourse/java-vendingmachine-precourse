package vendingmachine;

public class VendingMachine {
    private Coins currentBalance;
    private Items items;

    public Coins depositCurrentBalance(Coins currentBalance) {
        this.currentBalance = currentBalance;
        return this.currentBalance;
    }

    public Items storeItems(Items items) {
        this.items = items;
        return this.items;
    }
}
