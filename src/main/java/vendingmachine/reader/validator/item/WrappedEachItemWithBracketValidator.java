package vendingmachine.reader.validator.item;

import java.util.stream.Stream;
import vendingmachine.reader.ItemLineParser;
import vendingmachine.reader.validator.Validator;

public class WrappedEachItemWithBracketValidator implements Validator {
	private final ItemLineParser parser;

	public WrappedEachItemWithBracketValidator(ItemLineParser parser) {
		this.parser = parser;
	}

	@Override
	public boolean validate(String value) {
		String[] items = parser.splitBySemicolon(value);
		return Stream.of(items).allMatch(item -> item.startsWith("[") && item.endsWith("]"));
	}

	@Override
	public String getErrorMessage(String value, String inputValueName) {
		return "[ERROR] 개별 상품이 대괄호로 묶여 있지 않습니다.";
	}
}
