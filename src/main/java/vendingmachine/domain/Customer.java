package vendingmachine.domain;

public class Customer {
    private int inputMoneyToVendingMachine;

    public Customer(int InputMoneyToVendingMachine) {
        this.inputMoneyToVendingMachine = InputMoneyToVendingMachine;
    }

    public int getInputMoneyToVendingMachine() {
        return inputMoneyToVendingMachine;
    }

    @Override
    public String toString() {
        return "투입 금액 : "+ inputMoneyToVendingMachine;
    }
}
