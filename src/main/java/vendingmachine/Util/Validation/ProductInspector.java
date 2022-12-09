package vendingmachine.Util.Validation;

import vendingmachine.Domain.Product;

import static vendingmachine.Constant.Error.*;
import static vendingmachine.Constant.ProductConstant.*;
import static vendingmachine.Constant.ProductSeparator.*;

public class ProductInspector extends Validation {

    public void inputInitOrder(String order) {
        checkOrderInfo(order);
    }

    private void checkOrderInfo(String order) {
        String separator = String.valueOf(ORDER_SEPARATOR.getChar());

        if (order.contains(separator)) {
            checkOrderArray(order.split(separator));
            return;
        }
        order = prefixAndSuffix(order);

        checkOrderProducts(order);
    }

    private void checkOrderArray(String[] orders) {
        for (String order : orders) {
            checkOrderInfo(order);
        }
    }

    private void checkOrderProducts(String order) {
        String[] productInformation = order.split(PRODUCT_INFO_SEPARATOR.toString());

        if (productInformation.length != PRODUCT_INFO_SIZE.getValue()) {
            throw new IllegalArgumentException(NOT_PROPER_ORDER_COMMAND.toMessage());
        }

        productName(productInformation[PRODUCT_NAME_INDEX.getValue()]);
        productPrice(productInformation[PRODUCT_PRICE_INDEX.getValue()]);
        productCount(productInformation[PRODUCT_COUNT_INDEX.getValue()]);
    }

    private void productName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException(PRODUCT_NAME_BLANK.toMessage());
        }
    }

    private void productPrice(String price) {
        int productPrice = inputNumber(price);
        inputMoneyDivision(productPrice);
    }

    private void productCount(String count) {
        try {
            inputNumber(count);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NOT_ALLOWED_ORDER_ZERO.toMessage());
        }
    }

    public void productNameExist(String name, Product product) {
        if (product.getNames().contains(name)) return;

        throw new IllegalArgumentException(NOT_EXIST_PRODUCT_NAME.toMessage());
    }

    public void productSoldOut(String name, Product product) {
        if (product.getCount(name) < 1) {
            throw new IllegalArgumentException(SOLD_OUT_PRODUCT.toMessage());
        }
    }

}
