package vendingmachine.constant;

public enum Condition {
    LENGTH_0(0),
    MONEY_0(0),
    ONE_COIN(1);

    private int number;

    Condition(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}