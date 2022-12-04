package vendingmachine.utils;

public enum MachineConst {
    MIN_CASH(10),
    MAX_CASH(100000000),
    MIN_PRODUCT_AMOUNT(100),
    PRODUCT_NAME(0),
    PRODUCT_AMOUNT(1),
    PRODUCT_TOTAL(2);

    private final int value;

    MachineConst(int value) {
        this.value = value;
    }

    public int get() {
        return this.value;
    }
}
