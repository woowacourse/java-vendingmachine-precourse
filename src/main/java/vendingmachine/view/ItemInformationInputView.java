package vendingmachine.view;

import java.util.ArrayList;
import java.util.HashMap;

import vendingmachine.models.Item;
import vendingmachine.utils.Indexes;
import vendingmachine.utils.Validator;

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

	public String checkAllConditions(String nowInput) {
		try {
			ArrayList<String[]> parsedItem = generateDoubleSplit(nowInput);
			Validator.validateItemSize(parsedItem);
			Validator.validateElementCondition(parsedItem);
			return nowInput;
		}
		catch (IllegalArgumentException error) {
			System.out.print(error.getMessage());
			return BLANK_STRING;
		}
	}

	public String getInput() {
		OutputView.noticeItemInput();
		String nowInput = BLANK_STRING;
		while (nowInput.isEmpty()) {
			String userInput = camp.nextstep.edu.missionutils.Console.readLine();
			nowInput = checkAllConditions(userInput);
		}
		return nowInput;
	}

	public HashMap<String, Item> parse(String input) {
		HashMap<String, Item> parsedItem = new HashMap<>();
		ArrayList<String[]> nowParsedInput = generateDoubleSplit(input);
		for (String[] eachParsed : nowParsedInput) {
			parsedItem.put(eachParsed[Indexes.NAME_INDEX.getValue()],
				new Item(Integer.valueOf(eachParsed[Indexes.PRICE_INDEX.getValue()]),
					Integer.valueOf(eachParsed[Indexes.AMOUNT_INDEX.getValue()])));
		}
		return parsedItem;
	}
}
