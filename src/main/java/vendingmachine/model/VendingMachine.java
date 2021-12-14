package vendingmachine.model;

public class VendingMachine {
    private final Changes changes;
    private final DisplayMerchandise displayMerchandise;
    private int inputAmount;

    public VendingMachine(Changes changes, DisplayMerchandise displayMerchandise, int inputAmount) {
        this.changes = changes;
        this.displayMerchandise = displayMerchandise;
        this.inputAmount = inputAmount;
    }

    public Changes getChanges() {
        return changes;
    }

    public DisplayMerchandise getDisplayMerchandise() {
        return displayMerchandise;
    }

    public int getInputAmount() {
        return inputAmount;
    }

    public void subtractInputAmount(int price) {
        inputAmount -= price;
    }
}
