package vendingmachine.validation;

public class StringExistValidation implements Validation<String> {
	private static final String FORMAT = "%s '%s'은 비어있거나 null 입니다.";

	@Override
	public void validate(String target, String name) throws IllegalArgumentException {
		if (target == null || "".equals(target)) {
			throw new IllegalArgumentException(String.format(FORMAT, name, target));
		}
	}
}
