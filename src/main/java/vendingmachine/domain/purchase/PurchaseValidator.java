package vendingmachine.domain.purchase;

import static vendingmachine.StringConstants.*;

import java.util.Optional;

import vendingmachine.domain.item.Item;
import vendingmachine.domain.vendingMachine.VendingMachine;

public class PurchaseValidator {
    private final VendingMachine vendingMachine;

    public PurchaseValidator(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public boolean isAvailableStatus(Purchase purchase) {
        if (vendingMachine.isAllItemsSoldOut()) {
            return false;
        }

        if (!purchase.isAffordablePrice(vendingMachine.findLowestPriceInStock())) {
            return false;
        }
        return true;
    }

    public void validateByItemName(Purchase purchase, String itemName) {
        Item item = findItem(itemName);
        validateInStock(item);
        validateItemIsAffordable(purchase, findItem(itemName));
    }

    private Item findItem(String itemName) {
        Optional<Item> item = vendingMachine.findItemByItemName(itemName);
        if (!item.isPresent()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_NOT_EXIST_ITEM_TO_PURCHASE);
        }
        return item.get();
    }

    private void validateInStock(Item item) {
        if(!vendingMachine.isInStock(item)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_OUT_OF_STOCK);
        }
    }

    private void validateItemIsAffordable(Purchase purchase, Item item) {
        if (!purchase.isAffordablePrice(item.getPrice())) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_TOO_EXPENSIVE_ITEM_TO_PURCHASE);
        }
    }
}
