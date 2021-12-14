package vendingmachine.view.input.converter;

import vendingmachine.exception.MoneyNotNumericMessageException;

public class MoneyConverter {

	public static int convert(String inputString) {
		try {
			return Integer.parseInt(inputString);
		} catch (NumberFormatException ex) {
			throw new MoneyNotNumericMessageException();
		}
	}

}
