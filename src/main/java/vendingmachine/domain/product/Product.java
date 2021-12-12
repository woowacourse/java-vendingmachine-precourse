package vendingmachine.domain.product;

public class Product {
    private static final String INPUT_PRODUCT_PREFIX = "[";
    private static final String INPUT_PRODUCT_SUFFIX = "]";
    private static final String EMPTY = "";
    private static final String INPUT_PRODUCT_SPLIT_REGEX = ",";
    private static final int INPUT_PRODUCT_SPLIT_LIMIT = -1;

    private static final int NAME_INDEX = 0;
    private static final int PRICE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int DEFAULT_PRICE = 100;
    private static final int PRICE_QUOTIENT = 10;
    private static final int REMAINDER = 0;
    private static final int DEFAULT_QUANTITY = 0;

    private final String name;
    private final int price;
    private int quantity;

    public Product(String inputProduct) {
        validateStartWithAndEndWith(inputProduct);
        inputProduct = inputProduct.replace(INPUT_PRODUCT_PREFIX, EMPTY);
        inputProduct = inputProduct.replace(INPUT_PRODUCT_SUFFIX, EMPTY);

        String[] splitInputProduct = inputProduct.split(INPUT_PRODUCT_SPLIT_REGEX, INPUT_PRODUCT_SPLIT_LIMIT);
        validateSplitInputProduct(splitInputProduct);

        this.name = splitInputProduct[NAME_INDEX];
        this.price = Integer.parseInt(splitInputProduct[PRICE_INDEX]);
        this.quantity = Integer.parseInt(splitInputProduct[QUANTITY_INDEX]);
    }

    private void validateStartWithAndEndWith(String inputProduct) {
        if (!(inputProduct.startsWith(INPUT_PRODUCT_PREFIX) && inputProduct.endsWith(INPUT_PRODUCT_SUFFIX))) {
            throw new IllegalArgumentException();
        }
    }

    private void validateSplitInputProduct(String[] splitInputProduct) {
        validateName(splitInputProduct[NAME_INDEX]);
        validatePrice(splitInputProduct[PRICE_INDEX]);
        validateQuantity(splitInputProduct[QUANTITY_INDEX]);
    }

    private void validateName(String name) {
        validateEmpty(name);
        validateBlank(name);
    }

    private void validateEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBlank(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePrice(String inputPrice) {
        validateNumberFormat(inputPrice);
        int price = Integer.parseInt(inputPrice);

        validateNumberSize(price);
        validateDivide(price);
    }

    private void validateNumberSize(int price) {
        if (price < DEFAULT_PRICE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDivide(int price) {
        if (price % PRICE_QUOTIENT != REMAINDER) {
            throw new IllegalArgumentException();
        }
    }

    private void validateQuantity(String inputQuantity) {
        validateNumberFormat(inputQuantity);
        int quantity = Integer.parseInt(inputQuantity);
        validateNegativeNumber(quantity);
    }

    private void validateNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNegativeNumber(int quantity) {
        if (quantity < DEFAULT_QUANTITY) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isExistQuantity() {
        if (quantity > DEFAULT_QUANTITY) {
            return true;
        }
        return false;
    }

    public int getPrice() {
        return price;
    }

    public void decreaseQuantity() {
        validateQuantityZero();
        quantity--;
    }

    private void validateQuantityZero() {
        if (quantity == DEFAULT_QUANTITY) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isSameName(String productPurchaseName) {
        if (this.name.equals(productPurchaseName)) {
            return true;
        }
        return false;
    }
}