package vendingmachine;

import static vendingmachine.StringConstants.*;

import java.util.Optional;

import vendingmachine.coin.Coins;
import vendingmachine.item.Item;
import vendingmachine.item.Items;

public class VendingMachine {
    private final ChangeAccountant changeAccountant = new ChangeAccountant();
    private Coins coinBalance = new Coins();
    private Items items = new Items();
    private int moneyAvailable = 0;

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

    public void purchase(String itemName) {
        Item item = findItemToPurchase(itemName);
        validateCheaperThanMoneyAvailable(item);
        validateInStock(item);
        purchase(item);
    }

    public Coins giveChange() {
        Coins change = changeAccountant.change(moneyAvailable, coinBalance);
        moneyAvailable = changeAccountant.getRestAfterCalculation();
        coinBalance.take(change);
        return change;
    }

    public boolean isPurchaseAvailable() {
        if (!isMoreMoneyThanLowestPriceInStock() || isAllItemsSoldOut()) {
            return false;
        }
        return true;
    }

    private Item findItemToPurchase(String itemNameToPurchase) {
        Item itemToPurchase = findItem(itemNameToPurchase);
        return itemToPurchase;
    }

    private void validateCheaperThanMoneyAvailable(Item item) {
        if (item.isMoreExpensiveThanMoneyLeft(moneyAvailable)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_TOO_EXPENSIVE_ITEM_TO_PURCHASE);
        }
    }

    private void validateInStock(Item item) {
        if (!items.isInStock(item)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_OUT_OF_STOCK);
        }
    }

    private void purchase(Item item) {
        items.reduce(item);
        moneyAvailable -= item.getPrice();
    }

    private boolean isMoreMoneyThanLowestPriceInStock() {
        int minimumPrice = items.findLowestPriceInStock();
        if (moneyAvailable < minimumPrice) {
            return false;
        }
        return true;
    }

    private boolean isAllItemsSoldOut() {
        return items.isEmptyItems();
    }

    private Item findItem(String itemName) {
        Optional<Item> result = findItemInItems(itemName);
        if (!result.isPresent()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_NOT_EXIST_ITEM_TO_PURCHASE);
        }
        return result.get();
    }

    private Optional<Item> findItemInItems(String itemName) {
        return items.findByItemName(itemName);
    }
}
