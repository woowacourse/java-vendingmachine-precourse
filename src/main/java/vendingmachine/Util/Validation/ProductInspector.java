package vendingmachine.Util.Validation;

import vendingmachine.Domain.Product;

import java.util.List;

import static vendingmachine.Constant.Error.*;
import static vendingmachine.Constant.ProductConstant.*;
import static vendingmachine.Constant.ProductSeparator.ORDER_SEPARATOR;
import static vendingmachine.Constant.ProductSeparator.PRODUCT_INFO_SEPARATOR;

public class ProductInspector extends Validation {

    public void inputInitOrder(String order) {
        try {
            prefixAndSuffix(order);

            checkOrderInfo(order);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkOrderInfo(String order) {
        String separator = String.valueOf(ORDER_SEPARATOR.getChar());

        if (order.contains(separator)) {
            checkOrderArray(order.split(separator));
            return;
        }

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

    public void productNameExist(String name, List<Product> product) {
        for (Product productObject : product) {
            if (name.equals(productObject.getName())) return;
        }

        throw new IllegalArgumentException(NOT_EXIST_PRODUCT_NAME.toMessage());
    }

    public void productSoldOut(String name, List<Product> product) {
        for (Product productObject : product) {
            if (name.equals(productObject.getName()) && productObject.getCount() > 0) return;
        }

        throw new IllegalArgumentException(SOLD_OUT_PRODUCT.toMessage());
    }

}
