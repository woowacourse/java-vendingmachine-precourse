package vendingmachine.validation;

import java.util.regex.Matcher;

public class RegexMatchValidation implements Validation<Matcher> {
	private static final String FORMAT = "%s '%s'은 잘못된 입력입니다.(예시. '[콜라,1000,10]')";

	@Override
	public void validate(Matcher target, String name) throws IllegalArgumentException {
		if (!target.matches()) {
			throw new IllegalArgumentException(String.format(FORMAT, name, target));
		}
	}
}
