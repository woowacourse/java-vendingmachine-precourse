package vendingmachine.service;

import static vendingmachine.Constants.*;

import java.util.Arrays;
import java.util.List;

public class ProductService {
	public static List<String> splitBySemicolon(String inputLine) {
		return Arrays.asList(inputLine.split(STRING_SEMICOLON));
	}

	public static List<String> splitByComma(String inputLine) {
		inputLine = inputLine.substring(1, inputLine.length()-1);
		return Arrays.asList(inputLine.split(STRING_COMMA));
	}
}
