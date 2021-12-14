package vendingmachine.domain.vendingMachine;

import java.util.Optional;

import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.item.Item;
import vendingmachine.domain.item.Items;

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

    public boolean isAllItemsSoldOut() {
        return items.isEmptyItems();
    }

    public int findLowestPriceInStock() {
        return items.findLowestPriceInStock();
    }

    public Optional<Item> findItemByItemName(String itemName) {
        return items.findByItemName(itemName);
    }

    public boolean isInStock(Item item) {
        return items.isInStock(item);
    }

    public Item purchase(String itemName) {
        Item item = findItemByItemName(itemName).get();
        purchase(item);
        return item;
    }

    public Coins giveChange(int moneyAvailable) {
        Coins change = changeAccountant.change(moneyAvailable, coinBalance);
        leftMoney = changeAccountant.getRestAfterCalculation();
        coinBalance.take(change);
        return change;
    }

    private Item purchase(Item item) {
        items.reduce(item);
        return item;
    }
}
