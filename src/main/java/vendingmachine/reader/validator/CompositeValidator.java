package vendingmachine.reader.validator;

import java.util.Arrays;
import java.util.List;

public class CompositeValidator implements Validator {
	private final List<Validator> validators;

	public CompositeValidator(Validator... validators) {
		this.validators = Arrays.asList(validators);
	}

	@Override
	public boolean validate(String value) {
		return validators.stream().allMatch(validator -> validator.validate(value));
	}

	@Override
	public String getErrorMessage(String value, String inputValueName) {
		return validators.stream()
			.filter(validator -> !validator.validate(value))
			.findFirst()
			.get()
			.getErrorMessage(value, inputValueName);
	}
}
