package vendingmachine.constant;

public enum Condition {
    LENGTH_0(0),
    LENGTH_1(1),
    MONEY_0(0),
    QUANTITY_0(0),
    QUANTITY_1(1),
    ONE_COIN(1),
    INDEX_0(0),
    INDEX_1(1),
    INDEX_PRODUCT_NAME(0),
    INDEX_PRODUCT_COST(1),
    INDEX_PRODUCT_AMOUNT(2),
    PRODUCT_INFO_NUMBER(3),
    REMAINDER_0(0),
    QUOTIENT_1(1),
    DIVIDE_NUMBER(10),
    MINIMUM_COST(100),
    BRACKETS_NUMBER(2),
    ONE_SELL(1),
    NOTHING(-1);

    private int number;

    Condition(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}