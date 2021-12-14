package vendingmachine.purchase;

import vendingmachine.vendingMachine.VendingMachine;
import vendingmachine.coin.Coins;
import vendingmachine.item.Item;

public class PurchaseService {
    private final VendingMachine vendingMachine;
    private final PurchaseValidator purchaseValidator;
    private Purchase purchase;

    public PurchaseService(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        this.purchaseValidator = new PurchaseValidator(vendingMachine);
    }

    public void insertMoney(int money) {
        purchase = new Purchase(money);
    }

    public boolean isPurchaseAvailable() {
        return purchase.isAvailable(purchaseValidator);
    }

    public int showAvailableMoney() {
        return purchase.showAvailableMoney();
    }

    public Coins giveChange() {
        return vendingMachine.giveChange(purchase.end());
    }

    public void purchaseByItemName(String itemName) {
        purchase.validate(itemName, purchaseValidator);
        purchase.pay(vendingMachine.purchase(itemName).getPrice());
    }
}
