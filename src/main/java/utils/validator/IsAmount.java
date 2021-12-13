package utils.validator;

public class IsAmount implements Validator {
	public boolean run(StringBuilder input) {
		new IsDigit().run(input);

		if (isNegative(input) && hasNoSmallValue(input)) {
			throw new IllegalArgumentException("[ERROR] 음수단위의 금액은 사용할 수 없습니다.");
		}
		return true;
	}

	private boolean isNegative(StringBuilder input) {
		int amount = Integer.parseInt(input.toString());
		return amount <= 0;
	}

	private boolean hasNoSmallValue(StringBuilder input) {
		int amount = Integer.parseInt(input.toString());
		return amount % 10 != 0;
	}
}
