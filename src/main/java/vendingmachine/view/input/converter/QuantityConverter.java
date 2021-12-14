package vendingmachine.view.input.converter;

import vendingmachine.exception.QuantityNotNumericMessageException;

public class QuantityConverter {

	public static int convert(String inputString) {
		try {
			return Integer.parseInt(inputString);
		} catch (NumberFormatException ex) {
			throw new QuantityNotNumericMessageException();
		}
	}

}
