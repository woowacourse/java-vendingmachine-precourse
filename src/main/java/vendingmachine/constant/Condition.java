package vendingmachine.constant;

public enum Condition {
    LENGTH_0(0);

    private int number;

    Condition(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}