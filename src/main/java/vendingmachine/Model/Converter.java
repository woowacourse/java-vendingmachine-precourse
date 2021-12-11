package vendingmachine.Model;

import java.util.ArrayList;

import vendingmachine.Utils.Constants;

public class Converter {
	public static int getInt(String moneyString) {
		return Integer.parseInt(moneyString);
	}

	public static ArrayList<Object[]> getBeverages(String beverageString) {
		ArrayList<Object[]> beverages = new ArrayList<>();
		for (String beverage : beverageString.split(Constants.SEPARATOR)) {
			String[] values = beverage.substring(1, beverage.length() - 1).split(Constants.DELIMITER);
			beverages.add(new Object[]{values[0], getInt(values[1]), getInt(values[2])});
		}
		return beverages;
	}
}
