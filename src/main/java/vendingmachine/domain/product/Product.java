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
    private static final int DEFAULT_QUANTITY = 0;

    private final Name name;
    private final Price price;
    private int quantity;

    public Product(String inputProduct) {
        validateStartWithAndEndWith(inputProduct);
        inputProduct = inputProduct.replace(INPUT_PRODUCT_PREFIX, EMPTY);
        inputProduct = inputProduct.replace(INPUT_PRODUCT_SUFFIX, EMPTY);

        String[] splitInputProduct = inputProduct.split(INPUT_PRODUCT_SPLIT_REGEX, INPUT_PRODUCT_SPLIT_LIMIT);
        validateSplitInputProduct(splitInputProduct);

        this.name = new Name(splitInputProduct[NAME_INDEX]);
        this.price = new Price(splitInputProduct[PRICE_INDEX]);
        this.quantity = Integer.parseInt(splitInputProduct[QUANTITY_INDEX]);
    }

    private void validateStartWithAndEndWith(String inputProduct) {
        if (!(inputProduct.startsWith(INPUT_PRODUCT_PREFIX) && inputProduct.endsWith(INPUT_PRODUCT_SUFFIX))) {
            throw new IllegalArgumentException();
        }
    }

    private void validateSplitInputProduct(String[] splitInputProduct) {
        validateQuantity(splitInputProduct[QUANTITY_INDEX]);
    }

    private void validateQuantity(String inputQuantity) {
        validateNumberFormat(inputQuantity);
        int quantity = Integer.parseInt(inputQuantity);
        validateLeastQuantity(quantity);
    }

    private void validateNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLeastQuantity(int quantity) {
        if (quantity <= DEFAULT_QUANTITY) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPrice() {
        return price.getPrice();
    }

    public boolean isExistQuantity() {
        if (quantity > DEFAULT_QUANTITY) {
            return true;
        }
        return false;
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
        if (this.name.isSame(productPurchaseName)) {
            return true;
        }
        return false;
    }
}