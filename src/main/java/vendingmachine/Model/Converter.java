package vendingmachine.Model;

import java.util.ArrayList;

import vendingmachine.Utils.Constants;

public class Converter {
	public static int getInt(String moneyString) {
		return Integer.parseInt(moneyString);
	}

	public static ArrayList<String[]> getBeverages(String beverageString) {
		ArrayList<String[]> beverages = new ArrayList<>();
		for (String beverage : beverageString.split(Constants.SEPARATOR)) {
			beverages.add(
				beverage
				.substring(1, beverage.length() - 1)
				.split(Constants.DELIMITER));
		}
		return beverages;
	}
}
