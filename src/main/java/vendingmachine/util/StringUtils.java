package vendingmachine.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
	private static final String COMMA = ",";
	private static final String SEMI_COLON = ";";
	private static final String RIGHT_SQUARE_BRACKET = "[";
	private static final String LEFT_SQUARE_BRACKET = "]";
	private static final String REMOVED_SPACE = "";

	private StringUtils() {
	}

	public static List<String> splitProduct(String inputProducts) {
		return Arrays.asList(inputProducts.split(SEMI_COLON));
	}

	public static List<String> removeProductBrackets(List<String> inputProducts) {
		return inputProducts.stream().map(product -> product.replace(RIGHT_SQUARE_BRACKET, REMOVED_SPACE)
			.replace(LEFT_SQUARE_BRACKET, REMOVED_SPACE))
			.collect(Collectors.toList());
	}

	public static String[] parseProductDetail(String inputProduct) {
		return inputProduct.split(COMMA);
	}
}
