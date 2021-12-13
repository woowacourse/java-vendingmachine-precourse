package utils.validator;

public class IsAmount implements Validator {
	public boolean run(StringBuilder input) {
		new IsDigit().run(input);

		return isNotNegative(input) && hasNoSmallValue(input);
	}

	private boolean isNotNegative(StringBuilder input) {
		int amount = Integer.parseInt(input.toString());
		if (0 <= amount) {
			return true;
		}
		throw new IllegalArgumentException("[ERROR] 음수단위의 금액은 사용할 수 없습니다.");
	}

	private boolean hasNoSmallValue(StringBuilder input) {
		int amount = Integer.parseInt(input.toString());
		if (amount % 10 != 0) {
			return true;
		}
		throw new IllegalArgumentException("[ERROR] 10이하 단위의 금액은 사용할 수 없습니다.");
	}
}
