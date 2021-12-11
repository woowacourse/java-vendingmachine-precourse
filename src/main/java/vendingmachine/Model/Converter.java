package vendingmachine.Model;

import java.util.ArrayList;

import vendingmachine.Utils.Constants;

public class Converter {
	public static int convertToInt(String moneyString) {
		return Integer.parseInt(moneyString);
	}

	public static ArrayList<Object[]> convertToProducts(String productString) {
		ArrayList<Object[]> products = new ArrayList<>();
		for (String product : productString.split(Constants.SEPARATOR)) {
			String[] values = product
				.substring(1, product.length() - 1)
				.split(Constants.DELIMITER);
			products.add(new Object[]{values[0], convertToInt(values[1]), convertToInt(values[2])});
		}
		return products;
	}
}
