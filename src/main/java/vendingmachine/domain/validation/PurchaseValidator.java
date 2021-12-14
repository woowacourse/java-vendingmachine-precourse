package vendingmachine.domain.validation;

import vendingmachine.domain.Items;

public class PurchaseValidator {
    private Exception exception;

    public PurchaseValidator(Exception exception) {
        this.exception = exception;
    }

    private void checkExistsItemName(Items items, String name) {

        if (!items.existsItemName(name)) {
            exception.throwException(ErrorMessage.ITEM_NAME_NOT_EXISTS);
        }

    }

    private void checkInStock(Items items, String name) {

        if (!items.getItem(name).isInStock()) {
            exception.throwException(ErrorMessage.ITEM_NOT_IN_STOCK);
        }

    }

    private void checkEnoughMoney(Items items, String name, int money) {

        if (!items.getItem(name).isEnoughMoney(money)) {
            exception.throwException(ErrorMessage.LACK_PURCHASE_MONEY);
        }

    }

    public void checkCanPurchase(Items items, String name, int money) {
        checkExistsItemName(items, name);
        checkInStock(items, name);
        checkEnoughMoney(items, name, money);
    }

}
