package vendingmachine.util;

import java.util.Arrays;

import vendingmachine.view.ErrorMessage;

public class ItemValidator {

	public static final String ITEM_SEPARATOR = ";";
	public static final String ITEM_FORM = "^\\[[a-zA-Z가-힣]+,[1-9][0-9]*0,[1-9][0-9]+]$";

	public static void validate(String inputString) {
		Arrays.stream(inputString.split(ITEM_SEPARATOR))
			.filter(str -> !str.matches(ITEM_FORM))
			.findAny()
			.ifPresent(str -> {
				throw new IllegalArgumentException(ErrorMessage.WRONG_ITEM_INPUT);
			});
	}
}
