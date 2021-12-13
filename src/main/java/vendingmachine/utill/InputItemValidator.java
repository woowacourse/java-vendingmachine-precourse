package vendingmachine.utill;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InputItemValidator {
	private static final int ITEM_PRICE_INDEX = 1;
	private static final int ITEM_NAME_INDEX = 0;

	private static final String REGEX = "\\[[a-zA-Z0-9가-힣 _-]+,\\d{3,},\\d+]";
	private static final String DELIMITER = ",";

	List<String> itemNames = new ArrayList<>();

	public boolean validateItemList(List<String> itemList) {
		for (String item : itemList) {
			try {
				validateItemInfo(item);
			} catch (IllegalArgumentException e) {
				itemNames.clear();
				System.out.println(ErrorMsgConst.ERROR_MSG + e.getMessage());
				return false;
			}
		}
		return true;
	}

	private void validateItemInfo(String item) throws IllegalArgumentException {
		validateByRegex(item);
		String[] itemInfo = item.split(DELIMITER);
		InputMoneyValidator.validateIsDivisibleBy10(Integer.parseInt(itemInfo[ITEM_PRICE_INDEX]));
		validateNameDuplication(itemInfo[ITEM_NAME_INDEX]);
	}

	private void validateByRegex(String item) throws IllegalArgumentException {
		if (!Pattern.matches(REGEX, item)) {
			throw new IllegalArgumentException(ErrorMsgConst.ITEM_INPUT_ERROR_MSG);
		}
	}

	private void validateNameDuplication(String itemName) throws IllegalArgumentException {
		if (itemNames.contains(itemName)) {
			throw new IllegalArgumentException(ErrorMsgConst.ITEM_DUP_ERROR_MSG);
		}
		itemNames.add(itemName);
	}
}
