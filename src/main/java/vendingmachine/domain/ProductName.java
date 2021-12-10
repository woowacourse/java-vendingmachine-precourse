package vendingmachine.domain;

public class ProductName {
    public static final String ERROR_PREFIX = "[ERROR] 상품 이름은 ";
    public static final String ERROR_NAME_MESSAGE = "최소 한 글자 이상 입력해주세요.";

    private final String name;

    public ProductName(String name) {
        checkName(name);
        this.name = name;
    }

    private static void checkName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_NAME_MESSAGE);
        }
    }

    public boolean isSame(String name) {
        return this.name.equals(name);
    }
}
