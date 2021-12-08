package vendingmachine.util;

public class InputCondition {
	public static final int LOWER_LIMIT_MONEY = 0;
	public static final int MIN_MONEY_UNIT = 10;
	public static final int ZERO = 0;
	public static final String NUMBER_REGEX = "^[-]{0,1}[0-9]+";
	public static final String ITEM_REGEX = "(\\[[a-zA-Z0-9]+,[0-9]+0,[0-9]+0\\])";
	public static final String MULTIPLE_REGEX = ITEM_REGEX + "(;"+ ITEM_REGEX + ")*";
}
