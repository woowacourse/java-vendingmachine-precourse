package vendingmachine;

public class VendingMachine {
    private Coins coinBalance;
    private Items items;
    private int moneyAvailable;

    public Coins depositCoinBalance(Coins coinBalance) {
        this.coinBalance = coinBalance;
        return this.coinBalance;
    }

    public Items storeItems(Items items) {
        this.items = items;
        return this.items;
    }

    public void insertMoney(int money) {
        this.moneyAvailable = money;
    }
}
