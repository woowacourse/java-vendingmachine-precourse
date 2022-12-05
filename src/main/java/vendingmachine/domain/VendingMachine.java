package vendingmachine.domain;

public class VendingMachine {
    private final Change change;
    private final Shelf shelf;
    private int amount;

    public VendingMachine(Change change, Shelf shelf, int amount) {
        this.change = change;
        this.shelf = shelf;
        this.amount = amount;
    }


}
