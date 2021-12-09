package vendingmachine.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String RETRY_MESSAGE = " 다시 입력해주세요.";
    private static final String ALLOWED_AMOUNT_INPUT_FORMAT = "^[1-9][0-9]*[0]$";
    private static final String ALLOWED_PRODUCT_NAME_FORMAT = "^[a-zA-Z가-힣0-9]+$";
    private static final String ALLOWED_PRODUCT_PRICE_FORMAT = "^[1-9][0-9]*[0]$";
    private static final String ALLOWED_PRODUCT_QUANTITY_FORMAT = "^[1-9][0-9]*$";
    private static final String INVALID_AMOUNT_INPUT_MESSAGE = "금액은 숫자여야 합니다.";
    private static final String INVALID_PRODUCT_INPUT_MESSAGE = "마지막 문자가 세미콜론(;)일 수 없습니다.";
    private static final String INVALID_PRODUCT_MESSAGE = "각 상품은 [ ]로 감싸야 합니다.";
    private static final String INVALID_PRODUCT_COMPONENT_SIZE = "각 상품은 [상품명,가격,수량] 세 가지와 세미콜론(;)으로 구분됩니다.";
    private static final String INVALID_EACH_PRODUCT_INPUT_MESSAGE = "각 상품의 마지막 문자가 콤마(,)일 수 없습니다.";
    private static final String INVALID_PRODUCT_NAME = "상품명은 영문, 한글, 또는 숫자로 입력해야 합니다.";
    private static final String INVALID_PRODUCT_PRICE = "상품 가격은 숫자여야 하고, 10 단위로 나누어 떨어져야 합니다.";
    private static final String INVALID_PRODUCT_QUANTITY = "상품 수량은 숫자여야 하고, 1개 이상이어야 합니다.";
    private static final String EMPTY_PRODUCT_NAME = "상품명이 비어있습니다.";
    private static final String EMPTY_PRODUCT_PRICE = "상품 가격이 비어있습니다.";
    private static final String EMPTY_PRODUCT_QUANTITY = "상품 수량이 비어있습니다.";
    // private static final String ALLOWED_PRODUCT_INPUT_FORMAT = "^(\\[[가-힣]+,[1-9]+[0]+,[1-9]+[0-9]*\\])(;\\[[가-힣]+,[1-9]+[0]+,[1-9]+[0-9]*\\])*$";

    public static int validateAmountInput(String input) {
        if (!input.matches(ALLOWED_AMOUNT_INPUT_FORMAT)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_AMOUNT_INPUT_MESSAGE + RETRY_MESSAGE);
        }

        return Integer.parseInt(input);
    }

    public static List<List<String>> validateProductInput(String input) {
        return validateEachProduct(validateProductList(input));
    }

    private static List<String> validateProductList(String input) {
        if (input.endsWith(";")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_PRODUCT_INPUT_MESSAGE + RETRY_MESSAGE);
        }

        List<String> productList = Arrays.asList(input.split(";"));
        if (!productList.stream().allMatch(product -> product.startsWith("[") && product.endsWith("]"))) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_PRODUCT_MESSAGE + RETRY_MESSAGE);
        }

        return productList;
    }

    private static List<List<String>> validateEachProduct(List<String> productList) {
        List<List<String>> products = new ArrayList<>();
        for (String product : productList) {
            products.add(validateProductDetails(product.substring(1, product.length()-1)));
        }

        return products;
    }

    private static List<String> validateProductDetails(String productDetails) {
        if(productDetails.endsWith(",")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_EACH_PRODUCT_INPUT_MESSAGE + RETRY_MESSAGE);
        }

        List<String> productDetailList = Arrays.asList(productDetails.split(","));
        if (productDetailList.size() != 3) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_PRODUCT_COMPONENT_SIZE + RETRY_MESSAGE);
        }

        List<String> product = new ArrayList<>();
        product.add(validateProductName(productDetailList.get(0)));
        product.add(validateProductPrice(productDetailList.get(1)));
        product.add(validateProductQuantity(productDetailList.get(2)));

        return product;
    }

    private static String validateProductName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + EMPTY_PRODUCT_NAME + RETRY_MESSAGE);
        }

        if (!name.matches(ALLOWED_PRODUCT_NAME_FORMAT)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_PRODUCT_NAME + RETRY_MESSAGE);
        }

        return name;
    }

    private static String validateProductPrice(String price) {
        if (price.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + EMPTY_PRODUCT_PRICE + RETRY_MESSAGE);
        }

        if (!price.matches(ALLOWED_PRODUCT_PRICE_FORMAT)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_PRODUCT_PRICE + RETRY_MESSAGE);
        }

        return price;
    }

    private static String validateProductQuantity(String quantity) {
        if (quantity.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + EMPTY_PRODUCT_QUANTITY + RETRY_MESSAGE);
        }

        if(!quantity.matches(ALLOWED_PRODUCT_QUANTITY_FORMAT)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_PRODUCT_QUANTITY + RETRY_MESSAGE);
        }

        return quantity;
    }
}
