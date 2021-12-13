package utils.validator;

public class IsNotBlank implements Validator {
	public boolean run(StringBuilder input) {
		String inputStr = input.toString().trim();

		if (inputStr.isEmpty()) {
			throw new IllegalArgumentException("[ERROR] 상품 이름이 공백으로 이루어져 있습니다.");
		}

		return true;
	}
}
