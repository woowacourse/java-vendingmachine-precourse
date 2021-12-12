package vendingmachine.domain.productpurchase;

public class ProductPurchase {
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
            throw new IllegalArgumentException();
        }
    }

    private void validateBlank(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}