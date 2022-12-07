package vendingmachine.model;

public enum MachineStatus {
    AVAILABLE,
    TOO_LITTLE_BUDGET,
    NO_PRODUCT;

    public boolean isAvailable() {
        return this == AVAILABLE;
    }
}
