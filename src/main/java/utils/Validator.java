package utils;

import java.util.stream.Stream;

public interface Validator { // interface 로 변경 후, 체크할 에러에 대해 각각 클래스 생성할 것!

	public boolean run(StringBuilder input);
}

class Foo implements Validator {
	public boolean run(StringBuilder input) {
		return true;
	}
}

class isDigit implements Validator {
	public boolean run(StringBuilder input) {
		String digitRegex = "^[1-9][\\d]*[\\d]$";
		if (!input.toString().matches(digitRegex)) {
			throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
		}
		return false;
	}
}
