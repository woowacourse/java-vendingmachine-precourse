package vendingmachine.util;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_ONE = 1;
    private static final int INDEX_TWO = 2;
    private static final int PRODUCT_DETAIL_SIZE = 3;

    private static final String COMMA = ",";
    private static final String SEMI_COLON = ";";
    private static final String OPEN_SQUARE_BRACKET = "[";
    private static final String CLOSE_SQUARE_BRACKET = "]";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String RETRY_MESSAGE = " 다시 입력해주세요.";
    private static final String ALLOWED_AMOUNT_INPUT_FORMAT = "^[1-9][0-9]*[0]$";
    private static final String ALLOWED_PRODUCT_NAME_FORMAT = "^[a-zA-Z가-힣0-9]+$";
    private static final String ALLOWED_PRODUCT_PRICE_FORMAT = "^[1-9][0-9]*[0]$";
    private static final String ALLOWED_PRODUCT_QUANTITY_FORMAT = "^[1-9][0-9]*$";
    private static final String INVALID_AMOUNT_INPUT_MESSAGE = "금액은 숫자여야 합니다.";
    private static final String INVALID_PRODUCT_LIST_MESSAGE = "마지막 문자가 세미콜론(;)일 수 없습니다.";
    private static final String INVALID_PRODUCT_MESSAGE = "각 상품은 [ ]로 감싸야 합니다.";
    private static final String INVALID_PRODUCT_COMPONENT_SIZE_MESSAGE = "각 상품은 [상품명,가격,수량] 세 가지와 세미콜론(;)으로 구분됩니다.";
    private static final String INVALID_EACH_PRODUCT_INPUT_MESSAGE = "각 상품의 마지막 문자가 콤마(,)일 수 없습니다.";
    private static final String INVALID_PRODUCT_NAME = "상품명은 영문, 한글, 또는 숫자로 입력해야 합니다.";
    private static final String INVALID_PRODUCT_PRICE = "상품 가격은 10 단위로 나누어 떨어지는 `숫자`여야 합니다.";
    private static final String INVALID_PRODUCT_QUANTITY = "상품 수량은 1개 이상의 `숫자`여야 합니다.";
    private static final String EMPTY_PRODUCT_NAME = "상품명이 비어있습니다.";
    private static final String EMPTY_PRODUCT_PRICE = "상품 가격이 비어있습니다.";
    private static final String EMPTY_PRODUCT_QUANTITY = "상품 수량이 비어있습니다.";

    public static void validateAmountInput(String input) {
        if (!input.matches(ALLOWED_AMOUNT_INPUT_FORMAT)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_AMOUNT_INPUT_MESSAGE + RETRY_MESSAGE);
        }
    }

    public static void validateProductInput(String input) {
        List<String> productList = validateProductList(input);
        validateEachProduct(productList);
    }

    private static List<String> validateProductList(String input) {
        List<String> productList = validateLastCharacter(input, SEMI_COLON, INVALID_PRODUCT_LIST_MESSAGE);
        if (!productList.stream().allMatch(product ->
                product.startsWith(OPEN_SQUARE_BRACKET) && product.endsWith(CLOSE_SQUARE_BRACKET))) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_PRODUCT_MESSAGE + RETRY_MESSAGE);
        }

        return productList;
    }

    private static List<String> validateLastCharacter(String input, String lastCharacter, String givenMessage) {
        if (input.endsWith(lastCharacter)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + givenMessage + RETRY_MESSAGE);
        }

        return Arrays.asList(input.split(lastCharacter));
    }

    private static void validateEachProduct(List<String> productList) {
        for (String product : productList) {
            validateProductDetails(product.substring(INDEX_ONE, product.length() - INDEX_ONE));
        }
    }

    private static void validateProductDetails(String productDetails) {
        List<String> productDetailList = validateLastCharacter(productDetails, COMMA, INVALID_EACH_PRODUCT_INPUT_MESSAGE);
        if (productDetailList.size() != PRODUCT_DETAIL_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_PRODUCT_COMPONENT_SIZE_MESSAGE + RETRY_MESSAGE);
        }
        validateEachDetail(productDetailList);
    }

    private static void validateEachDetail(List<String> productDetailList) {
        validateEachDetail(productDetailList.get(INDEX_ZERO), EMPTY_PRODUCT_NAME,
                ALLOWED_PRODUCT_NAME_FORMAT, INVALID_PRODUCT_NAME);
        validateEachDetail(productDetailList.get(INDEX_ONE), EMPTY_PRODUCT_PRICE,
                ALLOWED_PRODUCT_PRICE_FORMAT, INVALID_PRODUCT_PRICE);
        validateEachDetail(productDetailList.get(INDEX_TWO), EMPTY_PRODUCT_QUANTITY,
                ALLOWED_PRODUCT_QUANTITY_FORMAT, INVALID_PRODUCT_QUANTITY);
    }

    private static void validateEachDetail(String name, String emptyMessage, String format, String invalidMessage) {
        validateEmpty(name, emptyMessage);
        validateRegex(name, format, invalidMessage);
    }

    public static void validateEmpty(String detail, String givenMessage) {
        if (detail.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + givenMessage + RETRY_MESSAGE);
        }
    }

    private static void validateRegex(String name, String format, String givenMessage) {
        if (!name.matches(format)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + givenMessage + RETRY_MESSAGE);
        }
    }
}