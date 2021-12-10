package vendingmachine;

public class VendingMachine {
    private Coins currentBalance;
    private Items items;
    private int moneyAvailable;

    public Coins depositCurrentBalance(Coins currentBalance) {
        this.currentBalance = currentBalance;
        return this.currentBalance;
    }

    public Items storeItems(Items items) {
        this.items = items;
        return this.items;
    }

    public void insertMoney(int money) {
        this.moneyAvailable = money;
    }
}
