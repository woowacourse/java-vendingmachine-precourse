package vendingmachine.Util.Validation;

import vendingmachine.Domain.Product;

import java.util.List;

import static vendingmachine.Constant.Error.*;
import static vendingmachine.Constant.Error.NOT_PROPER_ORDER_COMMAND;
import static vendingmachine.Constant.ProductConstant.PRODUCT_INFO_SIZE;
import static vendingmachine.Constant.ProductSeparator.*;
import static vendingmachine.Constant.ProductSeparator.PRODUCT_INFO_SEPARATOR;

public class ProductInspector extends Validation {

    public void productOrder(String order) {
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
