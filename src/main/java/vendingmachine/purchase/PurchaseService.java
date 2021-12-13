package vendingmachine.purchase;

import vendingmachine.vendingMachine.VendingMachine;
import vendingmachine.coin.Coins;
import vendingmachine.item.Item;

public class PurchaseService {
    private final VendingMachine vendingMachine;
    private Purchase purchase;

    public PurchaseService(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void insertMoney(int money) {
        purchase = new Purchase(money);
    }

    public boolean isPurchaseAvailable() {
        if (!isMoreMoneyThanLowestPriceInStock() || vendingMachine.isAllItemsSoldOut()) {
            return false;
        }
        return true;
    }

    public int showAvailableMoney() {
        return purchase.showAvailableMoney();
    }

    public Coins giveChange() {
        return vendingMachine.giveChange(purchase.end());
    }

    private boolean isMoreMoneyThanLowestPriceInStock() {
        int minimumPrice = vendingMachine.findLowestPriceInStock();
        if (purchase.isAffordablePrice(minimumPrice)) {
            return true;
        }
        return false;
    }

    public void purchaseByItemName(String itemName) {
        Item item = vendingMachine.findItemToPurchase(itemName);
        purchase.pay(item.getPrice());
        vendingMachine.purchase(item);
    }
}
