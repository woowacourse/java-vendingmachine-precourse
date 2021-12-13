package utils.validator;

public interface Validator { // interface 로 변경 후, 체크할 에러에 대해 각각 클래스 생성할 것!

	public boolean run(StringBuilder input);
}


