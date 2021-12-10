package vendingmachine;

import static vendingmachine.StringConstants.ERROR_MESSAGE_ABOUT_NOT_EXIST_ITEM_TO_PURCHASE;
import static vendingmachine.StringConstants.ERROR_MESSAGE_ABOUT_TOO_EXPENSIVE_ITEM_TO_PURCHASE;

import java.util.Optional;

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

    public void purchase(String itemNameToPurchase) {
        Item item = findItemToPurchase(itemNameToPurchase);
        if(items.isInStock(item)) {
            purchase(item);
        };
    }

    private Item findItemToPurchase(String itemNameToPurchase) {
        Item itemToPurchase = findItem(itemNameToPurchase);
        validateAvailableItem(itemToPurchase);
        return itemToPurchase;
    }

    private void purchase(Item item) {
        items.reduce(item);
        moneyAvailable -= item.getPrice();
    }

    private Item findItem(String itemName) {
        Optional<Item> result = findInItems(itemName);
        if (!result.isPresent()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_NOT_EXIST_ITEM_TO_PURCHASE);
        }
        return result.get();
    }

    private Optional<Item> findInItems(String itemName) {
        return items.findItemByItemName(itemName);
    }

    private void validateAvailableItem(Item item) {
        if (item.isMoreExpensiveItemThanMoneyLeft(moneyAvailable)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_TOO_EXPENSIVE_ITEM_TO_PURCHASE);
        }
    }

}
