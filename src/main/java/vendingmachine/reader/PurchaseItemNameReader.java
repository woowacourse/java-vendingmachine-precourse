package vendingmachine.reader;

import vendingmachine.reader.validator.CompositeValidator;
import vendingmachine.reader.validator.Validator;
import vendingmachine.reader.validator.item.HasEnoughMoneyValidator;
import vendingmachine.reader.validator.item.ExistsItemValidator;
import vendingmachine.reader.validator.item.HasQuantityItemValidator;

public class PurchaseItemNameReader extends Reader<String> {
	public PurchaseItemNameReader(Validator validator) {
		super(validator);
	}

	@Override
	protected void printInputMessage() {
		System.out.println("구매할 상품명을 입력해 주세요.");
	}

	@Override
	protected String parse(String value) {
		return value;
	}

	@Override
	protected String getInputValueName() {
		return "상품명";
	}

	public static RecursiveReader<String> recursiveReader() {
		return new RecursiveReader<>(
			new PurchaseItemNameReader(
				new CompositeValidator(
					new ExistsItemValidator(),
					new HasEnoughMoneyValidator(),
					new HasQuantityItemValidator())));
	}
}
