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

	public boolean validItemList(List<String> itemList) {
		for (String item : itemList) {
			try {
				validItemInfo(item);
			} catch (IllegalArgumentException e) {
				itemNames.clear();
				System.out.println(ErrorMsgConst.ERROR_MSG + e.getMessage());
				return false;
			}
		}
		return true;
	}

	private void validItemInfo(String item) throws IllegalArgumentException {
		validByRegex(item);
		String[] itemInfo = item.split(DELIMITER);
		InputMoneyValidator.validIsDivisibleBy10(Integer.parseInt(itemInfo[ITEM_PRICE_INDEX]));
		validNameDuplication(itemInfo[ITEM_NAME_INDEX]);
	}

	private void validByRegex(String item) throws IllegalArgumentException {
		if (!Pattern.matches(REGEX, item)) {
			throw new IllegalArgumentException(ErrorMsgConst.ITEM_INPUT_ERROR_MSG);
		}
	}

	private void validNameDuplication(String itemName) throws IllegalArgumentException {
		if (itemNames.contains(itemName)) {
			throw new IllegalArgumentException(ErrorMsgConst.ITEM_DUP_ERROR_MSG);
		}
		itemNames.add(itemName);
	}
}
