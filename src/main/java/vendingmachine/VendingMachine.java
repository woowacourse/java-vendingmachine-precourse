package vendingmachine;

import static vendingmachine.StringConstants.ERROR_MESSAGE_ABOUT_NOT_EXIST_ITEM_TO_PURCHASE;

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

    public int showAvailableMoney() {
        return moneyAvailable;
    }

    public void purchaseItem(String inputItemsToPurchase) {
        if (!items.isOnItemList(inputItemsToPurchase)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_NOT_EXIST_ITEM_TO_PURCHASE);
        }
    }
}
