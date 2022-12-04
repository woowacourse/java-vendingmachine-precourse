package vendingmachine.Util;

import vendingmachine.Domain.Product;

import java.util.List;

import static vendingmachine.Constant.Error.*;

public class Validation {

    private final char ORDER_PREFIX = '[';
    private final char ORDER_SUFFIX = ']';
    private final char ORDER_SEPARATOR = ';';
    private final char PRODUCT_INFO_SEPARATOR = ',';
    private final int PRODUCT_INFO_SIZE = 3;


    public int inputValueToNumber(String number) {
        int toNumber;

        try {
            toNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ALLOWED_ONLY_NUMBER.toMessage());
        }

        if(toNumber <= 0){
            throw new IllegalArgumentException(NOT_ALLOWED_MINUS_NUMBER.toMessage());
        }

        if(toNumber % 10 != 0){
            throw new IllegalArgumentException(NOT_ALLOWED_SINGLE_DIGIT.toMessage());
        }

        return toNumber;
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

    public void productOrder(String order) {
        try {
            checkPrefixAndSuffix(order);
            checkOrderInfo(order);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkPrefixAndSuffix(String order) {
        char prefix = order.charAt(0);
        char suffix = order.charAt(order.length() - 1);

        if (prefix != ORDER_PREFIX || suffix != ORDER_SUFFIX) {
            throw new IllegalArgumentException(NOT_PROPER_ORDER_COMMAND.toMessage());
        }
    }

    private void checkOrderInfo(String order) {
        String separator = String.valueOf(ORDER_SEPARATOR);

        if (order.contains(separator)) {
            checkOrderArray(order.split(separator));
            return;
        }

        checkOrderInfoCount(order);
    }

    private void checkOrderArray(String[] orders) {
        for (String order : orders) {
            checkOrderInfo(order);
        }
    }

    private void checkOrderInfoCount(String order) {
        String separator = String.valueOf(PRODUCT_INFO_SEPARATOR);

        if (order.split(separator).length != PRODUCT_INFO_SIZE) {
            throw new IllegalArgumentException(NOT_PROPER_ORDER_COMMAND.toMessage());
        }
    }


}
