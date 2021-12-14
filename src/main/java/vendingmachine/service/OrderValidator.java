package vendingmachine.service;

import vendingmachine.Constants.OrderConstant;
import vendingmachine.repository.Money;
import vendingmachine.repository.Product;
import vendingmachine.repository.Products;

public class OrderValidator {

    public boolean isValidMoney(String money) {
        if (!money.matches(OrderConstant.NUMERIC_REGEX)) {
            throw new IllegalArgumentException(OrderConstant.PRICE_NON_NUMERIC_ERROR_MESSAGE);
        }
        return true;
    }

    public boolean isExistProduct(String order, Products products) {
        if (!products.hasProduct(order)) {
            throw new IllegalArgumentException(OrderConstant.NON_EXIST_ERROR_MESSAGE);
        }
        return true;
    }

    public boolean isPossiblePrice(Product product, Money money) {
        if (product.getPrice() > money.getRemainder()) {
            throw new IllegalArgumentException(OrderConstant.EXPENSIVE_ERROR_MESSAGE);
        }
        return true;

    }

    public boolean hasStock(String order, Products products) {
        Product product = products.getProduct(order);
        if (product.isOutOfStock()) {
            throw new IllegalArgumentException(OrderConstant.NON_STOCK_ERROR_MESSAGE);
        }
        return true;
    }

}
