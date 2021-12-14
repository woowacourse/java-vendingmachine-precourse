package vendingmachine.service;

import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.purchase.Purchase;
import vendingmachine.domain.purchase.PurchaseValidator;
import vendingmachine.domain.vendingMachine.VendingMachine;

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

    public void purchaseByItemName(String itemName) {
        purchase.validate(itemName, purchaseValidator);
        purchase.pay(vendingMachine.purchase(itemName).getPrice());
    }

    public Coins change() {
        return vendingMachine.giveChange(purchase.end());
    }
}
