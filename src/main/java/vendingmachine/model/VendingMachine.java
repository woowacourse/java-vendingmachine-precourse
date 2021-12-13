package vendingmachine.model;

public class VendingMachine {
    private Changes changes;
    private DisplayMerchandise displayMerchandise;
    private int inputAmount;

    public VendingMachine(Changes changes, DisplayMerchandise displayMerchandise, int inputAmount) {
        this.changes = changes;
        this.displayMerchandise = displayMerchandise;
        this.inputAmount = inputAmount;
    }
}
