package vendingmachine.service;

import static vendingmachine.Constants.*;

import java.util.Arrays;
import java.util.List;

public class ProductService {
	public static List<String> splitProductsInformation(String inputLine) {
		return Arrays.asList(inputLine.split(STRING_SEMICOLON));
	}

	public static List<String> splitProductElements(String inputLine) {
		inputLine = inputLine.substring(NONE_BRACKET_INDEX, inputLine.length() - NONE_BRACKET_INDEX);
		return Arrays.asList(inputLine.split(STRING_COMMA));
	}
}
