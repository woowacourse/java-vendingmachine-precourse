package vendingmachine.domain.product;

public class Name {
    private static final String VALID_EMPTY = "[ERROR] 상품 이름이 비어있습니다.";
    private static final String VALID_BLANK = "[ERROR] 상품 이름이 공백입니다.";

    private final String name;

    public Name(String name) {
        validateEmpty(name);
        validateBlank(name);
        this.name = name;
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

    protected String getName() {
        return name;
    }

    public boolean isSame(String name) {
        if (this.name.equals(name)) {
            return true;
        }
        return false;
    }
}