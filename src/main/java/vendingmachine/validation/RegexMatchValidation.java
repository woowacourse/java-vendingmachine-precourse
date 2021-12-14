package vendingmachine.validation;

import java.util.regex.Matcher;

public class RegexMatchValidation implements Validation<Matcher> {
	private static final String FORMAT = "%s 의 입력이 잘못되었습니다. (예시. '[콜라,1000,10]')";

	@Override
	public void validate(Matcher target, String name) throws IllegalArgumentException {
		if (!target.matches()) {
			throw new IllegalArgumentException(String.format(FORMAT, name));
		}
	}
}
