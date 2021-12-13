package vendingmachine.domain.product;

public class Product {
    private static final String VALID_START_END_WITH = "[ERROR] 상품 입력은 '['로 시작하고 ']'로 끝나야 합니다.";
    private static final String VALID_NUMBER_FORMAT = "[ERROR] 상품 수량은 숫자여야 합니다.";
    private static final String VALID_LEAST_QUANTITY = "[ERROR] 상품 수량은 최소 1개 이상이어야 합니다.";

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
            throw new IllegalArgumentException(VALID_START_END_WITH);
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
            throw new IllegalArgumentException(VALID_NUMBER_FORMAT);
        }
    }

    private void validateLeastQuantity(int quantity) {
        if (quantity <= DEFAULT_QUANTITY) {
            throw new IllegalArgumentException(VALID_LEAST_QUANTITY);
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPrice() {
        return price.getPrice();
    }

    public boolean isSameName(String productPurchaseName) {
        if (this.name.isSame(productPurchaseName)) {
            return true;
        }
        return false;
    }

    public boolean isExistQuantity() {
        if (quantity > DEFAULT_QUANTITY) {
            return true;
        }
        return false;
    }

    public void purchase() {
        quantity--;
    }
}