package vendingmachine.util.constant;

public final class InputCondition {
    public static final String NUMBER_REGEX = "^[-]{0,1}[0-9]+";
    public static final String MERCHANDISE_REGEX = "^[\\[]{1}\\S{1,},{1}\\d{1,},{1}\\d{1,}[\\]]{1}$";
    public static final String SQUARE_BRACKET_REGEX = "[\\[\\]]";
    public static final int AMOUNT_MIN_RANGE = 100;
    public static final int INVENTORY_MIN_RANGE = 1;
    public static final int AMOUNT_UNIT = 10;
}
