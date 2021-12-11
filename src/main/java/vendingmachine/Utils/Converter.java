package vendingmachine.Utils;

import java.util.ArrayList;

public class Converter {
	public static int moneyConverter(String moneyString) {
		return Integer.parseInt(moneyString);
	}

	public static ArrayList<Object[]> productConverter(String productString) {
		ArrayList<Object[]> products = new ArrayList<>();
		for (String product : productsToArray(productString)) {
			products.add(stringToValues(product));
		}
		return products;
	}

	public static String[] productsToArray(String word) {
		return word.split(Constants.SEPARATOR);
	}

	public static Object[] stringToValues(String word) {
		String[] values = word.substring(1, word.length() - 1).split(Constants.DELIMITER);
		return new Object[]{values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2])};
	}
}
