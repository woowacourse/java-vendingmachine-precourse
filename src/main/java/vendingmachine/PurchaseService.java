package vendingmachine;

import vendingmachine.coin.Coins;
import vendingmachine.item.Item;

public class PurchaseService {
    private final VendingMachineService vendingMachineService;
    private Purchase purchase;

    public PurchaseService(VendingMachineService vendingMachineService) {
        this.vendingMachineService = vendingMachineService;
    }

    public void insertMoney(int money) {
        purchase = new Purchase(money);
    }

    public boolean isPurchaseAvailable() {
        if (!isMoreMoneyThanLowestPriceInStock() || findVendingMachine().isAllItemsSoldOut()) {
            return false;
        }
        return true;
    }

    public int showAvailableMoney() {
        return purchase.showAvailableMoney();
    }

    public Coins giveChange() {
        return findVendingMachine().giveChange(purchase.end());
    }

    private VendingMachine findVendingMachine() {
        return vendingMachineService.getVendingMachine();
    }

    private boolean isMoreMoneyThanLowestPriceInStock() {
        int minimumPrice = findVendingMachine().findLowestPriceInStock();
        if (purchase.isAffordablePrice(minimumPrice)) {
            return true;
        }
        return false;
    }

    public void purchaseByItemName(String itemName) {
        Item item = findVendingMachine().findItemToPurchase(itemName);
        purchase.pay(item.getPrice());
        findVendingMachine().purchase(item);
    }
}
