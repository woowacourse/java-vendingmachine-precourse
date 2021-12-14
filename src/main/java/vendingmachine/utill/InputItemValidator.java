package vendingmachine.utill;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InputItemValidator {
	private static final int ITEM_PRICE_INDEX = 1;
	private static final int ITEM_NAME_INDEX = 0;

	private static final String REGEX = "\\[[a-zA-Z0-9가-힣 _-]+,\\d{3,},\\d+]";
	private static final String DELIMITER = ",";
	private static final String OPEN_BRACKET = "[";

	List<String> itemNames = new ArrayList<>();

	public boolean validateItemList(List<String> itemList) {
		try {
			validateItems(itemList);
		} catch (IllegalArgumentException e) {
			itemNames.clear();
			System.out.println(ErrorMsgConst.ERROR_MSG + e.getMessage());
			return false;
		}
		return true;
	}

	private void validateItems(List<String> itemList) throws IllegalArgumentException {
		for (String item : itemList) {
			validateByRegex(item);
			String[] itemInfo = splitItem(item);
			InputMoneyValidator.validateIsDivisibleBy10(Integer.parseInt(itemInfo[ITEM_PRICE_INDEX]));
			validateNameDuplication(itemInfo[ITEM_NAME_INDEX]);
		}
	}

	private String[] splitItem(String item) {
		item = item.replace(OPEN_BRACKET, "");
		return item.split(DELIMITER);
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

	public boolean validateInputItemName(String itemName) {
		try {
			isExistInItemList(itemName);
		} catch (IllegalArgumentException e) {
			System.out.println(ErrorMsgConst.ERROR_MSG + e.getMessage());
			return false;
		}
		return true;
	}

	private void isExistInItemList(String itemName) throws IllegalArgumentException {
		if (!itemNames.contains(itemName)) {
			throw new IllegalArgumentException(ErrorMsgConst.ITEM_NOT_EXIST_ERROR_MSG);
		}
	}
}
