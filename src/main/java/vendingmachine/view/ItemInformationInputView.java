package vendingmachine.view;

import java.util.ArrayList;

public class ItemInformationInputView implements InputView {
	private static final String FIRST_DELIMITER = ";";
	private static final String SECOND_DELIMITER = ",";
	private static final String ITEM_START_PAREN = "[";
	private static final String ITEM_END_PAREN = "]";

	private ArrayList<String[]> generateDoubleSplit(String input) {
		ArrayList<String[]> doubleSplit = new ArrayList<>();
		String[] firstParsed = input.split(FIRST_DELIMITER);
		for (String eachFirstParsed : firstParsed) {
			eachFirstParsed = eachFirstParsed.replace(ITEM_START_PAREN, BLANK_STRING)
				.replace(ITEM_END_PAREN, BLANK_STRING);
			doubleSplit.add(eachFirstParsed.split(SECOND_DELIMITER));
		}
		return doubleSplit;
	}
}
