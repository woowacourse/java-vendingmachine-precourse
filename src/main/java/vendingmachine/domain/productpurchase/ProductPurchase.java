package vendingmachine.domain.productpurchase;

public class ProductPurchase {
    private static final String VALID_EMPTY = "[ERROR] 상품명이 비어있습니다.";
    private static final String VALID_BLANK = "[ERROR] 상품명은 공백이 될 수 없습니다.";

    private final String name;

    public ProductPurchase(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateEmpty(name);
        validateBlank(name);
    }

    private void validateEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(VALID_EMPTY);
        }
    }

    private void validateBlank(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(VALID_BLANK);
        }
    }

    public String getName() {
        return name;
    }
}