package vendingmachine.reader.validator.item;

import java.util.List;
import vendingmachine.reader.ItemLineParser;
import vendingmachine.reader.validator.number.NumberFormatValidator;
import vendingmachine.reader.validator.number.OverBoundaryValidator;
import vendingmachine.reader.validator.number.TenTimesNumberValidator;
import vendingmachine.reader.validator.Validator;

public class ItemPriceAndQuantityValidator implements Validator {
	private static final int BOUNDARY_VALUE = 100;
	private final NumberFormatValidator numberFormatValidator = new NumberFormatValidator();
	private final TenTimesNumberValidator tenTimesNumberValidator = new TenTimesNumberValidator();
	private final OverBoundaryValidator overBoundaryValidator = new OverBoundaryValidator(BOUNDARY_VALUE);
	private final ItemLineParser parser;

	public ItemPriceAndQuantityValidator(ItemLineParser parser) {
		this.parser = parser;
	}

	@Override
	public boolean validate(String value) {
		List<String[]> itemInfo = parser.parse(value);
		return isPriceAndQuantityNumberFormat(itemInfo) && isPriceOverBoundary(itemInfo) &&
			isPriceTenTimesNumber(itemInfo);
	}

	private boolean isPriceTenTimesNumber(List<String[]> itemInfo) {
		return itemInfo.stream().allMatch(this::isEachPriceTenTimesNumber);
	}

	private boolean isPriceAndQuantityNumberFormat(List<String[]> itemInfo) {
		return itemInfo.stream().allMatch(this::isEachPriceAndQuantityNumberFormat);
	}

	private boolean isPriceOverBoundary(List<String[]> itemInfo) {
		return itemInfo.stream().allMatch(this::isEachPriceOverBoundary);
	}

	private boolean isEachPriceAndQuantityNumberFormat(String[] item) {
		return numberFormatValidator.validate(item[1]) && numberFormatValidator.validate(item[2]);
	}

	private boolean isEachPriceTenTimesNumber(String[] item) {
		return tenTimesNumberValidator.validate(item[1]);
	}

	private boolean isEachPriceOverBoundary(String[] item) {
		return overBoundaryValidator.validate(item[1]);
	}

	@Override
	public String getErrorMessage(String value, String inputValueName) {
		return "[ERROR] 가격 또는 수량이 잘못됐습니다.";
	}
}
