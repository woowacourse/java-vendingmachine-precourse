package vendingmachine.domain.product;

public class Product {
    private static final String INPUT_PRODUCT_PREFIX = "[";
    private static final String INPUT_PRODUCT_SUFFIX = "]";
    private static final String EMPTY = "";
    private static final String INPUT_PRODUCT_SPLIT_REGEX = ",";
    private static final int INPUT_PRODUCT_SPLIT_LIMIT = -1;
    private static final int DEFAULT_STRING_SPLIT_LENGTH = 3;
    private static final int NAME_INDEX = 0;
    private static final int PRICE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    private static final String VALID_START_END_WITH = "[ERROR] 상품 입력은 '['로 시작하고 ']'로 끝나야 합니다.";
    private static final String VALID_PRODUCT_QUANTITY = "[ERROR] 상품의 수량이 부족합니다.";
    private static final String VALID_STRING_SPLIT_LENGTH = "[ERROR] 상품 입력 방식이 맞지 않습니다.";

    private final Name name;
    private final Price price;
    private final Quantity quantity;

    public Product(String inputProduct) {
        validateStartWithAndEndWith(inputProduct);
        inputProduct = inputProduct.replace(INPUT_PRODUCT_PREFIX, EMPTY);
        inputProduct = inputProduct.replace(INPUT_PRODUCT_SUFFIX, EMPTY);

        String[] splitInputProduct = inputProduct.split(INPUT_PRODUCT_SPLIT_REGEX, INPUT_PRODUCT_SPLIT_LIMIT);
        validateArrayLength(splitInputProduct.length);

        this.name = new Name(splitInputProduct[NAME_INDEX]);
        this.price = new Price(splitInputProduct[PRICE_INDEX]);
        this.quantity = new Quantity(splitInputProduct[QUANTITY_INDEX]);
    }

    private void validateStartWithAndEndWith(String inputProduct) {
        if (!(inputProduct.startsWith(INPUT_PRODUCT_PREFIX) && inputProduct.endsWith(INPUT_PRODUCT_SUFFIX))) {
            throw new IllegalArgumentException(VALID_START_END_WITH);
        }
    }

    private void validateArrayLength(int length) {
        if (length != DEFAULT_STRING_SPLIT_LENGTH) {
            throw new IllegalArgumentException(VALID_STRING_SPLIT_LENGTH);
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPrice() {
        return price.getPrice();
    }

    public boolean isSameName(String productPurchaseName) {
        return this.name.isSame(productPurchaseName);
    }

    public void receive() {
        if (!quantity.isExistQuantity()) {
            throw new IllegalArgumentException(VALID_PRODUCT_QUANTITY);
        }
        quantity.decreaseQuantity();
    }

    public boolean isExistQuantity() {
        return quantity.isExistQuantity();
    }
}