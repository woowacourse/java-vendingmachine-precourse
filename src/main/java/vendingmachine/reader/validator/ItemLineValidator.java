package vendingmachine.reader.validator;

import java.util.List;
import vendingmachine.reader.ItemLineParser;

public class ItemLineValidator implements Validator {
	private final NumberFormatValidator numberFormatValidator = new NumberFormatValidator();
	private final ItemLineParser parser;

	public ItemLineValidator(ItemLineParser parser) {
		this.parser = parser;
	}

	@Override
	public boolean validate(String value) {
		List<String[]> itemInfo = parser.parse(value);
		return itemInfo.stream().allMatch(this::isPriceAndQuantityNumberFormat);
	}

	@Override
	public String getErrorMessage(String value, String inputValueName) {
		return "[ERROR] 상품명, 가격, 수량 입력 포맷이 잘못됐습니다.";
	}

	private boolean isPriceAndQuantityNumberFormat(String[] item) {
		return numberFormatValidator.validate(item[1]) && numberFormatValidator.validate(item[2]);
	}
}
