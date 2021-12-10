package vendingmachine.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.Product;

public class Products {
    public static final String PRODUCTS_DELIMITER = ";";
    public static final String PRODUCT_DELIMITER = ",";
    public static final String PRODUCT_ELEMENTS_REPLACEMENT = "";
    public static final String PRODUCT_ELEMENTS_REGEX = "[\\[\\]]";
    public static final int PRODUCT_ELEMENT_COUNT = 3;
    public static final int CHECK_FORM_INDEX = 0;
    public static final int NAME_INDEX = 0;
    public static final int PRICE_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;
    public static final int CHANGE_TO_INDEX = 1;
    public static final char FORM_START_CHAR = '[';
    public static final char FORM_END_CHAR = ']';
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String ERROR_PRODUCT_FORM_MESSAGE = "한 상품의 내용은 "
        + FORM_START_CHAR + " 으로 시작해서 " + FORM_END_CHAR + " 으로 끝나야 합니다.";
    public static final String ERROR_PRODUCTS_FORM_MESSAGE = "양식에 맞게 다시 입력주세요. 예) [콜라,1500,20];[사이다,1000,10]";
    public static final String ERROR_INVALID_PRODUCT_NAME_MESSAGE = "존재하지 않는 상품입니다.";

    private final List<Product> products;

    public Products(String value) {
        products = new ArrayList<>();
        convertToProductsElement(value).forEach(elements ->
                products.add(Product.of(elements[NAME_INDEX], elements[PRICE_INDEX], elements[QUANTITY_INDEX]))
        );
    }

    public List<String[]> convertToProductsElement(String value) {
        return Arrays.stream(value.split(PRODUCTS_DELIMITER))
            .map(this::convertToProductElements).collect(Collectors.toList());
    }

    public String[] convertToProductElements(String value) {
        checkForm(value);
        String[] elements = value.replaceAll(PRODUCT_ELEMENTS_REGEX, PRODUCT_ELEMENTS_REPLACEMENT)
            .split(PRODUCT_DELIMITER);
        checkElementCount(elements.length);
        return elements;
    }

    private void checkForm(String value) {
        if (value.charAt(CHECK_FORM_INDEX) != FORM_START_CHAR
            || value.charAt(value.length() - CHANGE_TO_INDEX) != FORM_END_CHAR) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_PRODUCT_FORM_MESSAGE);
        }
    }

    private void checkElementCount(int count) {
        if (count != PRODUCT_ELEMENT_COUNT) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_PRODUCTS_FORM_MESSAGE);
        }
    }

    public void reduceQuantity(String productName) {
        findByName(productName).reduceQuantity();
    }

    public int getPriceByName(String productName) {
        return findByName(productName).getPrice();
    }

    public Product findByName(String productName) {
        return products.stream().filter(product -> product.isSameName(productName)).findFirst()
            .orElseThrow(() -> new IllegalArgumentException(ERROR_PREFIX + ERROR_INVALID_PRODUCT_NAME_MESSAGE));
    }

    public boolean isValidAmount(InputAmount inputAmount) {
        return !isOutOfStock() && canBuy(inputAmount);
    }

    private boolean isOutOfStock() {
        return products.stream().allMatch(Product::isOutOfStock);
    }

    private boolean canBuy(InputAmount inputAmount) {
        return products.stream().anyMatch(product -> product.isOrLess(inputAmount));
    }
}
