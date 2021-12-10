package vendingmachine;

import static vendingmachine.StringConstants.ERROR_MESSAGE_ABOUT_NOT_EXIST_ITEM_TO_PURCHASE;
import static vendingmachine.StringConstants.ERROR_MESSAGE_ABOUT_TOO_EXPENSIVE_ITEM_TO_PURCHASE;

import java.util.Optional;

import javax.swing.text.html.Option;

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

    public void purchaseItem(String itemNameToPurchase) {
        Optional<Item> result = findItem(itemNameToPurchase);
        if (!result.isPresent()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_NOT_EXIST_ITEM_TO_PURCHASE);
        }
        Item itemToPurchase = result.get();
        if (itemToPurchase.isMoreExpensiveItemThanMoneyLeft(moneyAvailable)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_TOO_EXPENSIVE_ITEM_TO_PURCHASE);
        }
    }

    private Optional<Item> findItem(String itemName) {
        return items.findByItemByItemName(itemName);
    }

}
