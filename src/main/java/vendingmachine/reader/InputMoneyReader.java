package vendingmachine.reader;

import vendingmachine.reader.validator.NumberFormatValidator;
import vendingmachine.reader.validator.Validator;

public class InputMoneyReader extends Reader<Integer>{
	public InputMoneyReader(Validator validator) {
		super(validator);
	}

	@Override
	protected void printInputMessage() {
		System.out.println("투입 금액을 입력해 주세요.");
	}

	@Override
	protected Integer parse(String value) {
		return Integer.valueOf(value);
	}

	@Override
	protected String getInputValueName() {
		return "투입 금액";
	}

	public static Reader<Integer> create() {
		return new InputMoneyReader(new NumberFormatValidator());
	}
}
