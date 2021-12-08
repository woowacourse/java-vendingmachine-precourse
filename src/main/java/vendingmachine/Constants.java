package vendingmachine;

import java.util.regex.Pattern;

public class Constants {
	public static final Pattern MONEY_PATTERN = Pattern.compile("^[1-9]+[0-9]*[0]$");
	public static final String ERROR = "[ERROR]";
}
