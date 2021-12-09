package vendingmachine.reader.validator.item;

import java.util.List;
import vendingmachine.reader.ItemLineParser;
import vendingmachine.reader.validator.Validator;

public class CountOfItemInformationValidator implements Validator {
	private final ItemLineParser parser;

	public CountOfItemInformationValidator(ItemLineParser parser) {
		this.parser = parser;
	}

	@Override
	public boolean validate(String value) {
		List<String[]> itemInfo = parser.parse(value);
		return itemInfo.stream().allMatch(this::isCorrectNumberOfInformation);
	}

	private boolean isCorrectNumberOfInformation(String[] item) {
		return item.length == 3;
	}

	@Override
	public String getErrorMessage(String value, String inputValueName) {
		return "[ERROR] 상품 정보에 대한 입력이 잘못됐습니다.";
	}
}
