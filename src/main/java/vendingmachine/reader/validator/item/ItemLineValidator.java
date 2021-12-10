package vendingmachine.reader.validator.item;

import vendingmachine.reader.validator.Validator;

public class ItemLineValidator implements Validator {
	private static final String ITEM_LINE_REGEX =
		"^(\\[[a-zA-Z가-힣0-9]+,[0-9]+,[0-9]+\\])(;\\[[a-zA-Z가-힣0-9]+,[0-9]+,[0-9]+\\])*$";

	@Override
	public boolean validate(String value) {
		return value.matches(ITEM_LINE_REGEX);
	}

	@Override
	public String getErrorMessage(String value, String inputValueName) {
		return "[ERROR] 상품정보가 잘못됐습니다.";
	}
}
