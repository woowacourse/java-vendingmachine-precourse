package utils.validator;

public class isDigit implements Validator {
	public boolean run(StringBuilder input) {
		String digitRegex = "^[1-9][\\d]*[\\d]$";
		if (!input.toString().matches(digitRegex)) {
			throw new IllegalArgumentException("[ERROR] 입력값이 올바른 숫자가 아닙니다.");
		}
		return false;
	}
}
