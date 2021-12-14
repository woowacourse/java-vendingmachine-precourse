package vendingmachine.reader.validator.item;

import static java.util.stream.Collectors.toList;

import java.util.List;

import vendingmachine.reader.ItemLineParser;
import vendingmachine.reader.validator.Validator;
import vendingmachine.reader.validator.number.OverBoundaryValidator;
import vendingmachine.reader.validator.number.TenTimesNumberValidator;

public class ItemPriceValidator implements Validator {
	private static final int BOUNDARY_VALUE = 100;
	private final TenTimesNumberValidator tenTimesNumberValidator = new TenTimesNumberValidator();
	private final OverBoundaryValidator overBoundaryValidator = new OverBoundaryValidator(BOUNDARY_VALUE);
	private final ItemLineParser parser;

	public ItemPriceValidator(ItemLineParser parser) {
		this.parser = parser;
	}

	@Override
	public boolean validate(String value) {
		List<String> prices = parser.parse(value).stream().map(item ->item[1]).collect(toList());
		return isOverBoundaryValue(prices) && isTenTimesValue(prices);
	}

	private boolean isOverBoundaryValue(List<String> prices) {
		return prices.stream().allMatch(overBoundaryValidator::validate);
	}

	private boolean isTenTimesValue(List<String> prices) {
		return prices.stream().allMatch(tenTimesNumberValidator::validate);
	}

	@Override
	public String getErrorMessage(String value, String inputValueName) {
		return "[ERROR] 가격이 잘못됐습니다.";
	}
}
