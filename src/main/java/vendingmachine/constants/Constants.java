package vendingmachine.constants;

public enum Constants {

    ERROR_PREFIX("[ERROR]");

    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
