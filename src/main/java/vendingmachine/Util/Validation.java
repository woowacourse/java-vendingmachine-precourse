package vendingmachine.Util;

import vendingmachine.Domain.Product;

import java.util.List;

import static vendingmachine.Constant.Error.*;
import static vendingmachine.Constant.ProductConstant.*;
import static vendingmachine.Constant.ProductSeparator.*;

public class Validation {

    public int inputValueToNumber(String number) {
        int toNumber;

        // TODO: 메소드 분리
        try {
            toNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ALLOWED_ONLY_NUMBER.toMessage());
        }

        if (toNumber <= 0) {
            throw new IllegalArgumentException(NOT_ALLOWED_MINUS_NUMBER.toMessage());
        }

        if (toNumber % MINIMUM_DIVIDED_PRICE.getValue() != 0) {
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

        if (prefix != ORDER_PREFIX.getChar() || suffix != ORDER_SUFFIX.getChar()) {
            throw new IllegalArgumentException(NOT_PROPER_ORDER_COMMAND.toMessage());
        }
    }

    private void checkOrderInfo(String order) {
        String separator = String.valueOf(ORDER_SEPARATOR.getChar());

        if (order.contains(separator)) {
            checkOrderArray(order.split(separator));
            return;
        }

        checkOrderDetail(order);
    }

    private void checkOrderArray(String[] orders) {
        for (String order : orders) {
            checkOrderInfo(order);
        }
    }

    // TODO: 메소드 분리
    private void checkOrderDetail(String order) {
        String separator = PRODUCT_INFO_SEPARATOR.toString();
        String[] orderDetails = order.split(separator);

        if (orderDetails.length != PRODUCT_INFO_SIZE.getValue()) {
            throw new IllegalArgumentException(NOT_PROPER_ORDER_COMMAND.toMessage());
        }

//        String a = orderDetails[PRODUCT_NAME_INDEX.getValue()];
//        String b = orderDetails[PRODUCT_PRICE_INDEX.getValue()];
//        String c = orderDetails[PRODUCT_COUNT_INDEX.getValue()];
    }

}
