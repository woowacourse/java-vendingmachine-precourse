package vendingmachine.domain;

public class Product {
    public static final int NAME_INDEX = 0;
    public static final int PRICE_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;
    public static final int CHECK_FORM_INDEX = 0;
    public static final int CHANGE_TO_INDEX = 1;
    public static final char FORM_START_CHAR = '[';
    public static final char FORM_END_CHAR = ']';
    public static final int PRODUCT_ELEMENT_COUNT = 3;
    public static final String PRODUCT_ELEMENTS_REPLACEMENT = "";
    public static final String PRODUCT_ELEMENTS_REGEX = "[\\[\\]]";
    public static final String PRODUCT_DELIMITER = ",";
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String ERROR_PRODUCT_FORM_MESSAGE = "한 상품의 내용은 "
        + FORM_START_CHAR + " 으로 시작해서 " + FORM_END_CHAR + " 으로 끝나야 합니다.";
    public static final String ERROR_PRODUCTS_FORM_MESSAGE = "양식에 맞게 다시 입력주세요. 예) [콜라,1500,20];[사이다,1000,10]";

    private final ProductName name;
    private final ProductPrice price;
    private final ProductQuantity quantity;

    public Product(String specification) {
        checkForm(specification);
        String[] elements = convertToElements(specification);
        this.name = new ProductName(elements[NAME_INDEX]);
        this.price = new ProductPrice(elements[PRICE_INDEX]);
        this.quantity = new ProductQuantity(elements[QUANTITY_INDEX]);
    }

    private String[] convertToElements(String specification) {
        String[] elements = specification
            .replaceAll(PRODUCT_ELEMENTS_REGEX, PRODUCT_ELEMENTS_REPLACEMENT).split(PRODUCT_DELIMITER);
        checkElementCount(elements);
        return elements;
    }

    private void checkForm(String specification) {
        if (specification.charAt(CHECK_FORM_INDEX) != FORM_START_CHAR
            || specification.charAt(specification.length() - CHANGE_TO_INDEX) != FORM_END_CHAR) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_PRODUCT_FORM_MESSAGE);
        }
    }

    private void checkElementCount(String[] elements) {
        if (elements.length != PRODUCT_ELEMENT_COUNT) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_PRODUCTS_FORM_MESSAGE);
        }
    }

    public int getPrice() {
        return price.get();
    }

    public void reduceQuantity() {
        quantity.reduce();
    }

    public boolean isOutOfStock() {
        return quantity.isLessThanThreshold();
    }

    public boolean isOrLess(int amount) {
        return price.isOrLess(amount);
    }

    public boolean isSameName(String productName) {
        return name.isSame(productName);
    }
}
