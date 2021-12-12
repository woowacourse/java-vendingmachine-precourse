package vendingmachine.validation;

public class IntegerParsableValidation implements Validation<String> {

	private static final String FORMAT = "%s (으)로 입력된 %s 은(는) 올바른 숫자값이 아닙니다.";

	@Override
	public void validate(String target, String name) {
		try {
			int parsed = Integer.parseInt(target);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(String.format(FORMAT, name, target));
		}
	}
}
