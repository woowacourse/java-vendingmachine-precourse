package vendingmachine;

public class Product {
    public static final int MIN_PRICE = 100;
    private String name;
    private int price;

    public Product(String name, int price) {
        validate(name, price);
        this.name = name;
        this.price = price;
    }

    private void validate(String name, int price) {
        validateName(name);
        validatePrice(price);
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("상품의 이름은 null이거나 빈 문자열일 수 없습니다.");
        }
    }

    private void validatePrice(int price) {
        if (price < MIN_PRICE) {
            throw new IllegalArgumentException("상품의 가격은 100원 이상이어야 합니다.");
        }
        if (price % 10 != 0) {
            throw new IllegalArgumentException("상품의 가격은 10원 단위여야 합니다.");
        }
    }

}
