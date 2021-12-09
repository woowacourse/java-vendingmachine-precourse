package vendingmachine.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.ItemValidator;

public class ItemController {
	public static List<String> getInputValue() {
		String inputString = Console.readLine();
		try {
			ItemValidator.validate(inputString);
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			return getInputValue();
		}

		return Arrays.stream(inputString.split(";"))
			.collect(Collectors.toList());
	}
}
