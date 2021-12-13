package vendingmachine.vendingMachine;

import static vendingmachine.StringConstants.*;

import java.util.Optional;

import vendingmachine.coin.Coins;
import vendingmachine.item.Item;
import vendingmachine.item.Items;

public class VendingMachine {
    private final ChangeAccountant changeAccountant = new ChangeAccountant();
    private Coins coinBalance = new Coins();
    private Items items = new Items();
    private int leftMoney = 0;

    public Coins depositCoinBalance(Coins coinBalance) {
        this.coinBalance = coinBalance;
        return this.coinBalance;
    }

    public Items storeItems(Items items) {
        this.items = items;
        return this.items;
    }

    public Coins giveChange(int moneyAvailable) {
        Coins change = changeAccountant.change(moneyAvailable, coinBalance);
        leftMoney = changeAccountant.getRestAfterCalculation();
        coinBalance.take(change);
        return change;
    }

    private void validateInStock(Item item) {
        if (!items.isInStock(item)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_OUT_OF_STOCK);
        }
    }

    public void purchase(Item item) {
        items.reduce(item);
    }

    public int findLowestPriceInStock() {
        return items.findLowestPriceInStock();
    }

    public boolean isAllItemsSoldOut() {
        return items.isEmptyItems();
    }

    private Item findItemByItemName(String itemName) {
        Optional<Item> result = items.findByItemName(itemName);
        if (!result.isPresent()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_NOT_EXIST_ITEM_TO_PURCHASE);
        }
        return result.get();
    }

    public Item findItemToPurchase(String itemName) {
        Item item = findItemByItemName(itemName);
        validateInStock(item);
        return item;
    }
}
