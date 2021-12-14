package vendingmachine.reader;

import camp.nextstep.edu.missionutils.Console;

import vendingmachine.reader.validator.Validator;

public abstract class Reader<T> {
	private Validator validator;

	public Reader(Validator validator) {
		this.validator = validator;
	}

	public T read() {
		printInputMessage();
		String value = Console.readLine();

		if (!validator.validate(value)) {
			throw new IllegalArgumentException(validator.getErrorMessage(value, getInputValueName()));
		}

		return parse(value);
	}

	protected abstract void printInputMessage();

	protected abstract T parse(String value);

	protected abstract String getInputValueName();
}
