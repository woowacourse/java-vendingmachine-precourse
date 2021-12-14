package vendingmachine.service;

import vendingmachine.repository.ChangeRepository;
import vendingmachine.repository.ProductRepository;

import static vendingmachine.repository.ProductRepository.isExist;
import static vendingmachine.view.ExceptionMessages.*;

public class BuyService {
    private final ProductRepository productRepository = ProductRepository.getInstance();
    private final ChangeRepository changeRepository = ChangeRepository.getInstance();

    public void sellProduct(String name) {
        changeRepository.subtractChange(productRepository.substractProductQuantity(name));
    }

    public void isValidOrderName(String order, int change) {
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

    private boolean hasEnoughMoney(String name, int change) {
        if (change < productRepository.getProductPrice(name, change)) {
            return false;
        }
        return true;
    }

    private boolean hasEnoughQuantity(String name) {
        if (productRepository.getProductQuantity(name) > 0) {
            return true;
        }
        return false;
    }

    public boolean isAvailableKeepSell(int change) {
        boolean canBuy = false;
        for (String name : productRepository.getProductNameSet()) {
            if (productRepository.getProductPrice(name, change) < change
                    && productRepository.getProductQuantity(name) > 0) {
                canBuy = true;
                return canBuy;
            }
        }
        return canBuy;
    }
}
