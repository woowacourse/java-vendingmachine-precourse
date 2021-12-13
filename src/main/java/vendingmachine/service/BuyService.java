package vendingmachine.service;

import static vendingmachine.repository.ChangeRepository.subtractChange;
import static vendingmachine.repository.ProductRepository.*;
import static vendingmachine.view.Messages.*;

public class BuyService {

    public static void sellProduct(String name) {
        subtractChange(substractProductQuantity(name));
    }

    public static void isValidOrderName(String order, int change) {
        if (!isExist(order)) {
            throw new IllegalArgumentException(ERROR_NOT_INVALID_ORDER_NAME);
        }
        if (!hasEnoughMoney(order, change)) {
            throw new IllegalArgumentException(ERROR_LESS_CHANGE);
        }
        if (!hasEnoughQuantity(order)) {
            throw new IllegalArgumentException(ERROR_LESS_QUANTITY);
        }
    }

    private static boolean hasEnoughMoney(String name, int change) {
        if (change < getProductPrice(name, change)) {
            return false;
        }
        return true;
    }

    private static boolean hasEnoughQuantity(String name) {
        if (getProductQuantity(name) > 0) {
            return true;
        }
        return false;
    }

    public static boolean isAvailableKeepSell(int change) {
        boolean canBuy = false;
        for (String name : getProductNameSet()) {
            if (getProductPrice(name, change) < change
                    && getProductQuantity(name) > 0) {
                canBuy = true;
                return canBuy;
            }
        }
        return canBuy;
    }
}
