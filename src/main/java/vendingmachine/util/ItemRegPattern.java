package vendingmachine.util;

import java.util.regex.Pattern;

public class ItemRegPattern {
	private static Pattern pattern = null;
	private static String ITEM_INPUT_REG = "\\[([^,]+),(\\d+),(\\d+)\\]";

	private ItemRegPattern() {

	}

	public static Pattern getPattern() {
		if (pattern == null) {
			pattern = Pattern.compile(ITEM_INPUT_REG);
		}
		return pattern;
	}
}
