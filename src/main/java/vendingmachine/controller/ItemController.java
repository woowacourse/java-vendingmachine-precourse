package vendingmachine.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.ItemValidator;

public class ItemController {

	public static final String ITEM_SEPARATOR = ";";

	public static List<String> getInputItemForm() {
		String inputString = Console.readLine();
		try {
			ItemValidator.validateItemForm(inputString);
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			return getInputItemForm();
		}
		return Arrays.stream(inputString.split(ITEM_SEPARATOR))
			.collect(Collectors.toList());
	}
}
