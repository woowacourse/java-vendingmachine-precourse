package vendingmachine;

import vendingmachine.customer.CustomerController;
import vendingmachine.exception.NotEnoughMoneyException;
import vendingmachine.exception.NotEnoughStockException;
import vendingmachine.item.ItemController;

public class VendingMachineSystem {

    private final int PURCHASE_UNIT = 1;
    private ItemController itemController;
    private CustomerController customerController;

    private VendingMachineSystem() {
        itemController = ItemController.getInstance();
        customerController = CustomerController.getInstance();
    }

    public void purchaseItem(String itemName) {
        int price = itemController.getPriceByName(itemName);
        try{
            itemController.hasStockQuantity(itemName, PURCHASE_UNIT);
            customerController.hasPurchaseAmount(price);

            itemController.purChaseItem(itemName, PURCHASE_UNIT);
            customerController.purchaseItem(price);
        }catch(NotEnoughStockException e) {
            customerController.cancelPurchase(price);
            throw new IllegalArgumentException(e.getMessage());
        }catch(NotEnoughMoneyException e) {
            itemController.cancelPurchase(itemName, PURCHASE_UNIT);
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
