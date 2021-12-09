package vendingmachine.domain;

public class VendingMachine {

    private final Changes changes;

    public VendingMachine(int seedMoney) {
        changes = new Changes(seedMoney);
    }

    public Changes getChanges() {
        return changes;
    }
}
