package vendingmachine.util.validator;

import vendingmachine.util.ErrorMessage;
import vendingmachine.util.InputCondition;

public class ItemInfoValidator {

	public static void validateItemInfo(String input){
		validFormat(input);
	}

	private static void validFormat(String input){
		if(!input.matches(InputCondition.MULTIPLE_REGEX)){
			throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage() + ErrorMessage.INVALID_ITEM_INFO_FORMAT);
		}
	}


}
