package vendingmachine.domain.product;

public class Name {
    private final String name;

    public Name(String name) {
        validateEmpty(name);
        validateBlank(name);
        this.name = name;
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

    public boolean isSame(String name) {
        if (this.name.equals(name)) {
            return true;
        }
        return false;
    }
}